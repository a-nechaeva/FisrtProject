package com.example.fisrtproject.data

import kotlinx.serialization.Serializable

@Serializable
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val icon: Int,
    val screenshots: List<String>? = null,
    val description: String,
)