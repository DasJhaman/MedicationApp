package com.example.medicationapp.ui.drugdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.medicationapp.ui.navigation.ArgumentsNameHelper.DrugDetailScreen.drugName
import com.example.medicationapp.ui.navigation.ArgumentsNameHelper.DrugDetailScreen.drugStrength
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DrugDetailsScreenViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _uiData = MutableStateFlow(DrugDetailScreenUIData())
    val uiData: StateFlow<DrugDetailScreenUIData> = _uiData.asStateFlow()


    init {
        val drugName: String? = savedStateHandle[drugName]
        val drugStrength: String? = savedStateHandle[drugStrength]
        _uiData.update { prev ->
            prev.copy(drugName = drugName ?: "", drugStrength = drugStrength ?: "")
        }
    }
}