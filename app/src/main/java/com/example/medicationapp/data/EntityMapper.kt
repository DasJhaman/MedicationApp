package com.example.medicationapp.data

import com.example.medicationapp.data.db.entity.AssociatedDrugEntity
import com.example.medicationapp.domain.models.AssociatedDrug

internal fun List<AssociatedDrugEntity>.toAssociateDrug() = map {
    it.toAssociateDrug()
}

internal fun AssociatedDrugEntity.toAssociateDrug() = AssociatedDrug(
    drugName = name,
    drugStrength = strength,
    drugDose = dose
)