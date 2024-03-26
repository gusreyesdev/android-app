package com.timetonic.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.timetonic.R


@Composable
fun OutTextFieldComp(
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isRequired: Boolean = false,
    onValueChanged: (String) -> Unit
) {
    var textValue by remember { mutableStateOf("kminchelle") }
    var isError by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = textValue, onValueChange = {
                textValue = it
                isError = it.isEmpty()
                onValueChanged(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = label) },
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            singleLine = true,
            isError = isError
        )

        if (isRequired && isError) {
            Text(
                text = stringResource(id = R.string.help_required),
                color = if (isError) MaterialTheme.colorScheme.error else Color.Black
            )
        }
    }
}

@Composable
fun OutTextFieldPasswordComp(
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isRequired: Boolean = false,
    onValueChanged: (String) -> Unit

) {
    var textValue by remember { mutableStateOf("0lelplR") }
    var isError by remember { mutableStateOf(false) }
    var passwordShow by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = textValue, onValueChange = {
                textValue = it
                isError = it.isEmpty()
                onValueChanged(it)
            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = label) },
            keyboardOptions = keyboardOptions,
            singleLine = true,
            isError = isError,
            trailingIcon = {
                val image =
                    if (passwordShow) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility

                IconButton(onClick = { passwordShow = !passwordShow }) {
                    Icon(imageVector = image, contentDescription = "password")
                }
            },
            visualTransformation = if(passwordShow) VisualTransformation.None else PasswordVisualTransformation()
        )

        if (isRequired && isError) {
            Text(
                text = stringResource(id = R.string.help_required),
                color = if (isError) MaterialTheme.colorScheme.error else Color.Black
            )
        }
    }


}
