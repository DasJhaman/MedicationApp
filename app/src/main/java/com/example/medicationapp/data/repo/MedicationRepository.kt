package com.example.medicationapp.data.repo

import com.example.medicationapp.data.RepositoryResult
import com.example.medicationapp.data.api.medication.MedicationApi
import com.example.medicationapp.domain.AssociatedDrug
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

internal class MedicationRepository internal constructor(
    private val medicationApi: MedicationApi
) {

    suspend fun getAssociatedDrugsListing() = flow<RepositoryResult<out List<AssociatedDrug>>> {
        medicationApi.getListOfMedicine().onSuccess {
            val associatedDrugs =
                it.problems.firstOrNull()?.diabetes?.firstOrNull()?.medications?.firstOrNull()?.medications?.firstOrNull()?.medicationSub?.firstOrNull()?.associatedDrug
            associatedDrugs?.let {
                emit(RepositoryResult.Success(it.toAssociateDrug()))
            } ?: emit(RepositoryResult.Error(null, "TODO"))

        }.onFailure {
            emit(RepositoryResult.Error(null, "TODO"))

        }
    }.onStart {
        emit(RepositoryResult.Loading)
    }
}