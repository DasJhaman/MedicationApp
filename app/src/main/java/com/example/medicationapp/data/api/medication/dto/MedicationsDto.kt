package com.example.medicationapp.data.api.medication.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MedicationsDto(
    @SerialName("medicationsClasses")
    val medications: List<MedicationsClassesDto>
)
