package com.example.fisrtproject.data.api

import com.example.fisrtproject.data.model.AppDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("catalog")
    suspend fun getCatalog(): List<AppDetailsDto>

    @GET("catalog/{id}")
    suspend fun getAppById(@Path("id") id: String): AppDetailsDto
}