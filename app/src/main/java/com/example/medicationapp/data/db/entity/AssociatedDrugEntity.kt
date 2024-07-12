package com.example.medicationapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
@Entity(tableName = tableName)
data class AssociatedDrugEntity(
    @PrimaryKey(autoGenerate = true)
    @SerialName("_id")
    val id: Int = 0,
    @SerialName("drug_name")
    val name: String,
    @SerialName("drug_dose")
    val dose: String,
    @SerialName("drug_strength")
    val strength: String
)

const val tableName = "AssociatedDrugEntity"