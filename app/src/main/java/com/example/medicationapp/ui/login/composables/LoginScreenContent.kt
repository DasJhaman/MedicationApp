package com.example.medicationapp.ui.login.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.medicationapp.R
import com.example.medicationapp.ui.components.DefaultButton
import com.example.medicationapp.ui.components.DefaultTextField
import com.example.medicationapp.ui.login.LoginScreenUIData

@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    loginScreenUIData: LoginScreenUIData,
    onUserEmailUpdate: (String) -> Unit,
    onUserPasswordUpdate: (String) -> Unit,
    onResetPasswordClick: () -> Unit,
    onLoginButtonClick: () -> Unit,
    onSignupClick: () -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(focusRequester) {
        focusRequester.requestFocus()
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        DefaultTextField(
            modifier = Modifier.focusRequester(focusRequester),
            labelTitle = stringResource(id = R.string.login_label_email_name),
            errorTitle = stringResource(id = R.string.login_email_error_message),
            value = loginScreenUIData.email ?: "",
            isError = loginScreenUIData.hasUserEmailError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Next
            ),
            onValueChange = onUserEmailUpdate,
            textStyle = TextStyle.Default.copy(color = MaterialTheme.colorScheme.onBackground),
        )

        Spacer(modifier = Modifier.height(20.dp))

        DefaultTextField(
            labelTitle = stringResource(id = R.string.login_label_password),
            errorTitle = stringResource(id = R.string.login_password_error_message),
            value = loginScreenUIData.password ?: "",
            isError = loginScreenUIData.hasPasswordError,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                },
            ),
            onValueChange = onUserPasswordUpdate,
            textStyle = TextStyle.Default.copy(color = MaterialTheme.colorScheme.onBackground),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.login_forget_password_label),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable { onResetPasswordClick() },
        )

        Spacer(modifier = Modifier.height(20.dp))

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.login_button),
            onClick = {
                keyboardController?.hide()
                onLoginButtonClick()
            },
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.login_no_account),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary,
                textAlign = TextAlign.End,
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = stringResource(id = R.string.sign_up),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Start,
                modifier = Modifier.clickable {
                    onSignupClick()
                },
            )
        }
    }
}