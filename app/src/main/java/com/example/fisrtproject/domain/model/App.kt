package com.example.fisrtproject.domain.model

data class App(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val size: Double,
    val icon: Int,
    val screenshots: List<String>?,
    val description: String
)