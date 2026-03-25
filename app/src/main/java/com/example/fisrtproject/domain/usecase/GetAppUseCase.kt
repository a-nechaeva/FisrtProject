package com.example.fisrtproject.domain.usecase

import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAppUseCase @Inject constructor(
    private val repository: AppRepository
) {
    suspend fun execute(): Result<List<App>> {
        return repository.getAllApps()
    }
}