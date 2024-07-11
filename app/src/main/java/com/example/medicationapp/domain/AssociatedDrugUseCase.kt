package com.example.medicationapp.domain

import com.example.medicationapp.data.repo.MedicationRepository

class AssociatedDrugUseCase internal constructor(private val medicationRepository: MedicationRepository) {

    operator fun invoke() = medicationRepository.getAssociatedDrugsListing()

}