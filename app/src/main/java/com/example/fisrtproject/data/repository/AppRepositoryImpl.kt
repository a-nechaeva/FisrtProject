package com.example.fisrtproject.data.repository

import com.example.fisrtproject.data.api.ApiService
import com.example.fisrtproject.data.mapper.AppMapper
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AppRepository {

    override suspend fun getAllApps(): Result<List<App>> {
        return try {
            val dtos = apiService.getCatalog()
            Result.success(AppMapper.toDomainList(dtos))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAppById(id: String): Result<App> {
        return try {
            val dto = apiService.getAppById(id)
            Result.success(AppMapper.toDomain(dto))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}