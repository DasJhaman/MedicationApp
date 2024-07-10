package com.example.medicationapp.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiData = MutableStateFlow(LoginScreenUIData())
    val uiData: StateFlow<LoginScreenUIData> = _uiData.asStateFlow()

    private val actionsSharedFlow = MutableSharedFlow<LoginScreenApiResult>()
    val actionsFlow: Flow<LoginScreenApiResult> = actionsSharedFlow


    fun updateUserEmail(email: String) {
        _uiData.update { prev ->
            prev.copy(email = email)
        }
    }

    fun updateUserPassword(password: String) {
        _uiData.update { prev ->
            prev.copy(password = password)
        }
    }

    fun login() {
        viewModelScope.launch {
            // TODO: Validate and Call login API
            if (!_uiData.value.email.isNullOrEmpty() && !_uiData.value.password.isNullOrEmpty()) {
                actionsSharedFlow.emit(LoginScreenApiResult.LoggedInSuccessfully)
            } else {
                actionsSharedFlow.emit(LoginScreenApiResult.LoggedInFailed("Please input all the fields"))
            }
        }

    }
}