package com.example.medicationapp.data.repo

import com.example.medicationapp.data.api.medication.dto.AssociatedDrugOneDto
import com.example.medicationapp.domain.models.AssociatedDrug


internal fun List<AssociatedDrugOneDto>.toAssociateDrug() = map {
    it.toAssociateDrug()
}

internal fun AssociatedDrugOneDto.toAssociateDrug() = AssociatedDrug(
    drugDose = dose,
    drugStrength = strength,
    drugName = name
)