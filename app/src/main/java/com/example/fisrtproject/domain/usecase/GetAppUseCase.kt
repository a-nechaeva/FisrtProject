package com.example.fisrtproject.domain.usecase

import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAppUseCase @Inject constructor(
    private val repository: AppRepository
) {
     fun execute(): List<App> {
        return repository.getAllApps()
    }
}