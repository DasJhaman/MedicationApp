package com.example.medicationapp.data.api.medication

import com.example.medicationapp.data.api.medication.dto.MedicationResponseDto
import com.example.medicationapp.data.api.medication.dto.ProblemsDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class MedicationApi(private val ktorClient: HttpClient) {

    suspend fun getListOfMedicine(): Result<MedicationResponseDto> = runCatching {
        return@runCatching ktorClient.get("v3/70dd3fd3-2d9f-41d2-ba78-8830fc988876").body()

    }
}