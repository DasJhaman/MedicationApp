package com.example.medicationapp.data.api.medication.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MedicationsClassesDto(
    @SerialName("className")
    val medicationSub: List<MedicationSubDto>
)
