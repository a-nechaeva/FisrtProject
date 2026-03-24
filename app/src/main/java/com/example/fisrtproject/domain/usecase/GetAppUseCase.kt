package com.example.fisrtproject.domain.usecase

import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.repository.AppRepository

class GetAppUseCase(
    private val repository: AppRepository
) {
     fun execute(): List<App> {
        return repository.getAllApps()
    }
}