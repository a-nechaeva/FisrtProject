package com.example.fisrtproject.domain.usecase

import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAppByIdUseCase @Inject constructor(
    private val repository: AppRepository
) {
    suspend fun execute(id: String): Result<App> {
        return repository.getAppById(id)
    }
}