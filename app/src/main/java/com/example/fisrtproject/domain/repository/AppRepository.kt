package com.example.fisrtproject.domain.repository

import com.example.fisrtproject.domain.model.App

interface AppRepository {
    suspend fun getAllApps(): Result<List<App>>
    suspend fun getAppById(id: String): Result<App>
}