package com.example.medicationapp.data.api.medication.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MedicationSubDto(
    @SerialName("associatedDrug")
    val associatedDrug: List<AssociatedDrugOneDto>
)