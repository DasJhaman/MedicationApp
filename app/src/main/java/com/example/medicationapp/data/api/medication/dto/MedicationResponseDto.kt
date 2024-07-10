package com.example.medicationapp.data.api.medication.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MedicationResponseDto(
    @SerialName("problems")
    val problems: List<ProblemsDto>
)