package com.example.medicationapp.ui.dashboard

import com.example.medicationapp.domain.models.AssociatedDrug
import com.example.medicationapp.ui.common.ContentState

data class DashboardUIData(
    val userId: String? = null,
    val contentState: ContentState = ContentState.LOADING,
    val associateDrugs: List<AssociatedDrug> = emptyList()
)
