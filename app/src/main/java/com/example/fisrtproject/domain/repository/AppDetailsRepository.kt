package com.example.fisrtproject.domain.repository

import com.example.fisrtproject.domain.model.AppDetails

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): Result<AppDetails>
}