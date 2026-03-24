package com.example.fisrtproject.domain.repository

import com.example.fisrtproject.domain.model.App

interface AppRepository {
    fun getAllApps(): List<App>
    fun getAppById(id: String): App?
}