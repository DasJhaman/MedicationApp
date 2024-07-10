package com.example.medicationapp.ui.login.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicationapp.ui.login.LoginScreenUIData

@Composable
fun LoginScreenContentWithStates(
    modifier: Modifier = Modifier,
    loginScreenUIData: LoginScreenUIData,
    onUserEmailUpdate: (String) -> Unit = {},
    onUserPasswordUpdate: (String) -> Unit = {},
    onResetPasswordClick: () -> Unit = {},
    onLoginButtonClick: () -> Unit = {},
    onSignupClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoginScreenContent(
            modifier = modifier,
            loginScreenUIData = loginScreenUIData,
            onUserEmailUpdate = onUserEmailUpdate,
            onUserPasswordUpdate = onUserPasswordUpdate,
            onResetPasswordClick = onResetPasswordClick,
            onLoginButtonClick = onLoginButtonClick,
            onSignupClick = onSignupClick

        )
    }
}

@Preview
@Composable
fun LoginScreenContentWithStatesPreview() {
    LoginScreenContentWithStates(
        loginScreenUIData = LoginScreenUIData()
    )
}