package com.example.fisrtproject.data.repository

import com.example.fisrtproject.data.api.ApiService
import com.example.fisrtproject.data.local.AppDetailsDao
import com.example.fisrtproject.data.local.AppDetailsEntityMapper
import com.example.fisrtproject.data.mapper.AppDetailsMapper
import com.example.fisrtproject.domain.repository.AppDetailsRepository
import com.example.fisrtproject.domain.model.AppDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDetailsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val dao: AppDetailsDao,
    private val appDetailsMapper: AppDetailsMapper,
    private val entityMapper: AppDetailsEntityMapper
) : AppDetailsRepository {

    override suspend fun getAppDetails(id: String): Result<AppDetails> {
        return try {
            val entity = dao.getAppDetails(id).first()

            if (entity != null) {
                Result.success(entityMapper.toDomain(entity))
            } else {
                val dto = apiService.getAppById(id)

                val domainModel = appDetailsMapper.toDomain(dto)

                withContext(Dispatchers.IO) {
                    val entityToSave = entityMapper.toEntity(domainModel)
                    dao.insertAppDetails(entityToSave)
                }

                Result.success(domainModel)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}