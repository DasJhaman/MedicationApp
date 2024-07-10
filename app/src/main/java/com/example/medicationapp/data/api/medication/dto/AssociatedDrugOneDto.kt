package com.example.medicationapp.data.api.medication.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AssociatedDrugOneDto(
    @SerialName("name")
    val name: String,
    @SerialName("dose")
    val dose: String,
    @SerialName("strength")
    val strength: String

)
