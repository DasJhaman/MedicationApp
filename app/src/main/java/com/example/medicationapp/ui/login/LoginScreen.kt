package com.example.medicationapp.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.medicationapp.R
import com.example.medicationapp.ui.common.ContentState
import com.example.medicationapp.ui.components.TopAppBar
import com.example.medicationapp.ui.login.composables.LoginScreenContentWithStates
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    onSuccessfullyLoggedIn: (String) -> Unit,
    loginViewModel: LoginViewModel = getViewModel()
) {

    val uiData by loginViewModel.uiData.collectAsStateWithLifecycle()

    val actionsFlow = loginViewModel.actionsFlow
    LaunchedEffect(actionsFlow) {
        actionsFlow.collect { triggeredAction ->
            when (triggeredAction) {
                LoginScreenApiResult.LoggedInSuccessfully -> onSuccessfullyLoggedIn(
                    uiData.email ?: ""
                )

                is LoginScreenApiResult.LoggedInFailed -> {
                    // TODO:Show error dialog or snackbar state..
                }
            }
        }
    }
    LoginScreenStateless(
        loginScreenUIData = uiData,
        onUserPasswordUpdate = loginViewModel::updateUserPassword,
        onUserEmailUpdate = loginViewModel::updateUserEmail,
        onResetPasswordClick = {
            // TODO: Move to Reset password Screen
        },
        onLoginButtonClick = loginViewModel::login
    )
}

@Composable
fun LoginScreenStateless(
    loginScreenUIData: LoginScreenUIData,
    onUserEmailUpdate: (String) -> Unit = {},
    onUserPasswordUpdate: (String) -> Unit = {},
    onResetPasswordClick: () -> Unit = {},
    onLoginButtonClick: () -> Unit = {},
    onSignupClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                screenTitle = stringResource(id = R.string.login),
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            LoginScreenContentWithStates(
                loginScreenUIData = loginScreenUIData,
                onUserEmailUpdate = onUserEmailUpdate,
                onUserPasswordUpdate = onUserPasswordUpdate,
                onResetPasswordClick = onResetPasswordClick,
                onLoginButtonClick = onLoginButtonClick,
                onSignupClick = onSignupClick
            )

        }
    }

}