package com.timetonic.auth.login.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.timetonic.R
import com.timetonic.auth.login.data.network.model.LoginResponse
import com.timetonic.ui.components.OutTextFieldComp
import com.timetonic.ui.components.OutTextFieldPasswordComp

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val username: String by loginViewModel.username.observeAsState("")
    val password: String by loginViewModel.password.observeAsState("")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(false)
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState(false)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        val (loginColum) = createRefs()

        Column(modifier = modifier
            .padding(horizontal = dimensionResource(id = R.dimen.common_padding_horizontal))
            .constrainAs(loginColum) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }) {

            if (isLoading) {
                CircularProgressIndicator()
            } else {

                OutTextFieldComp(
                    label = stringResource(id = R.string.username_text_field),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    isRequired = true
                ) {
                    loginViewModel.onLoginChanged(username = it, password = password)
                }

                OutTextFieldPasswordComp(
                    label = stringResource(id = R.string.password_text_field),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    isRequired = true
                ) {
                    loginViewModel.onLoginChanged(username = username, password = it)
                }

                Button(modifier = modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.login_button_padding)),
                    contentPadding = PaddingValues(),
                    enabled = isLoginEnable,
                    onClick = {
                        loginViewModel.login(
                            username,
                            password
                        )
                    }) {
                    Text(text = stringResource(id = R.string.login_text_button))
                }
            }
        }
    }
}