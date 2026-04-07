package com.example.fisrtproject.domain.usecase

import com.example.fisrtproject.domain.model.AppDetails
import com.example.fisrtproject.domain.repository.AppDetailsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAppDetailsUseCase @Inject constructor(
    private val repository: AppDetailsRepository
) {
    suspend fun execute(id: String): Result<AppDetails> {
        return repository.getAppDetails(id)
    }
}