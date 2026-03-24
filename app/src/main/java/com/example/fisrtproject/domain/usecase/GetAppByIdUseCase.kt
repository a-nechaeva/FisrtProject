package com.example.fisrtproject.domain.usecase

import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.repository.AppRepository

class GetAppByIdUseCase (
    private val repository: AppRepository
) {
    fun execute(id: String): App? {
        return repository.getAppById(id)
    }
}