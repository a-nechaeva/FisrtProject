package com.example.fisrtproject.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Category (val displayName: String) {
    @SerialName("Финансы")
    FINANCE("Финансы"),

    @SerialName("Транспорт")
    TRAVEL("Транспорт"),

    @SerialName("Инструменты")
    UTILITIES("Инструменты");

}