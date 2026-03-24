package com.example.fisrtproject.data.repository

import com.example.fisrtproject.data.AppData
import com.example.fisrtproject.data.mapper.AppMapper
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(): AppRepository {
    override fun getAllApps(): List<App> {
        return AppMapper.toDomainList(AppData.appList)
    }

    override fun getAppById(id: String): App? {
        return AppData.getAppById(id)?.let { AppMapper.toDomain(it) }
    }
}