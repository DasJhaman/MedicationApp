package com.example.medicationapp.data

sealed class RepositoryResult<T> {
    data object Loading : RepositoryResult<Nothing>()
    data class Success<T>(val data: T) : RepositoryResult<T>()
    data class Error<T>(val lastKnownData: T?, val error: String) : RepositoryResult<T>()
}