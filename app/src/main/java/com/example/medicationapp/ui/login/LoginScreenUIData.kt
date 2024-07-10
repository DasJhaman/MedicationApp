package com.example.medicationapp.ui.login

import androidx.compose.runtime.Immutable


data class LoginScreenUIData(
    val email: String? = null,
    val password: String? = null,
    val hasUserEmailError: Boolean = false,
    val hasPasswordError: Boolean = false
)


@Immutable
sealed class LoginScreenApiResult {
    data object LoggedInSuccessfully : LoginScreenApiResult()
    data class LoggedInFailed(val errorMessage: String) : LoginScreenApiResult()
}