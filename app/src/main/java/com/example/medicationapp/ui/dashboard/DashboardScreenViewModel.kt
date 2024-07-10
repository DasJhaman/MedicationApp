package com.example.medicationapp.ui.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.medicationapp.ui.navigation.ArgumentsNameHelper.DashboardScreen.userId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DashboardScreenViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _uiData = MutableStateFlow(DashboardUIData())
    val uiData: StateFlow<DashboardUIData> = _uiData.asStateFlow()

    init {
        val userId: String? = savedStateHandle[userId]
        _uiData.update { prev ->
            prev.copy(userId = userId)
        }
    }


}