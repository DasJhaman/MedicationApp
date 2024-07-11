package com.example.medicationapp.ui.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicationapp.data.RepositoryResult
import com.example.medicationapp.domain.AssociatedDrugUseCase
import com.example.medicationapp.ui.common.ContentState
import com.example.medicationapp.ui.navigation.ArgumentsNameHelper.DashboardScreen.userId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DashboardScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val associatedDrugUseCase: AssociatedDrugUseCase
) : ViewModel() {

    private val _uiData = MutableStateFlow(DashboardUIData())
    val uiData: StateFlow<DashboardUIData> = _uiData.asStateFlow()

    init {
        val userId: String? = savedStateHandle[userId]
        _uiData.update { prev ->
            prev.copy(userId = userId)
        }
        getAssociatedDrugs()
    }


    private fun getAssociatedDrugs() {
        viewModelScope.launch {
            associatedDrugUseCase().collect {
                when(it){
                    is RepositoryResult.Error -> _uiData.update { prev-> prev.copy(contentState = ContentState.ERROR) }
                    RepositoryResult.Loading -> _uiData.update { prev-> prev.copy(contentState = ContentState.LOADING) }
                    is RepositoryResult.Success -> _uiData.update { prev-> prev.copy(contentState = ContentState.SUCCESS, associateDrugs = it.data) }
                }

            }
        }
    }


}