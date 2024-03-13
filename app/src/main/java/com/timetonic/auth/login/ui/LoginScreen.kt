package com.timetonic.auth.login.ui

import android.app.Application
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.timetonic.R
import com.timetonic.core.Constants
import com.timetonic.ui.components.OutTextFieldComp
import com.timetonic.ui.components.OutTextFieldPasswordComp
import dagger.hilt.android.internal.Contexts

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel
) {
    val email: String by viewModel.email.observeAsState("")
    val password: String by viewModel.password.observeAsState("")
    val isLoginEnable: Boolean by viewModel.isLoginEnable.observeAsState(false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(false)
    val appName = stringResource(id = R.string.app_name)

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
                    label = stringResource(id = R.string.email_text_field),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isRequired = true
                ) {
                    viewModel.onLoginChanged(email = it, password = password)
                }

                OutTextFieldPasswordComp(
                    label = stringResource(id = R.string.password_text_field),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    isRequired = true
                ) {
                    viewModel.onLoginChanged(email = email, password = it)
                }

                Button(modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = dimensionResource(id = R.dimen.button_padding_vertical)),
                    enabled = isLoginEnable,
                    onClick = {
                        viewModel.onCreateAppKeyModel(
                            version = Constants.VERSION,
                            req = Constants.CREATEAPPKEY,
                            appname = appName
                        )
                    }) {
                    Text(text = stringResource(id = R.string.common_button))
                }
            }
        }
    }
}