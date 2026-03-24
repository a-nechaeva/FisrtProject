package com.example.fisrtproject.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CategoryDto(val displayName: String) {
    @SerialName("Финансы")
    FINANCE("Финансы"),

    @SerialName("Транспорт")
    TRAVEL("Транспорт"),

    @SerialName("Инструменты")
    UTILITIES("Инструменты"),
}