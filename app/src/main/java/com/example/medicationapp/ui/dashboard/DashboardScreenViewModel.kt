package com.example.medicationapp.ui.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.medicationapp.ui.navigation.ArgumentsNameHelper.DashboardScreen.userId

class DashboardScreenViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    init {
        val userId: String? = savedStateHandle[userId]

    }
}