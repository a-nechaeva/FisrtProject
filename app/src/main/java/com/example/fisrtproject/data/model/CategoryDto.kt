package com.example.fisrtproject.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CategoryDto(val displayName: String) {
    @SerializedName("Финансы")
    @SerialName("Финансы")
    FINANCE("Финансы"),

    @SerializedName("Транспорт")
    @SerialName("Транспорт")
    TRAVEL("Транспорт"),

    @SerializedName("Утилиты")
    @SerialName("Утилиты")
    UTILITIES("Утилиты"),

    @SerializedName("Производительность")
    @SerialName("Производительность")
    PRODUCTIVITY("Производительность"),

    @SerializedName("Здоровье и фитнес")
    @SerialName("Здоровье и фитнес")
    HEALTH("Здоровье и фитнес"),

    @SerializedName("Фото и видео")
    @SerialName("Фото и видео")
    PHOTO("Фото и видео"),

    @SerializedName("Еда и Напитки")
    @SerialName("Еда и Напитки")
    FOOD("Еда и Напитки"),

    @SerializedName("Образование")
    @SerialName("Образование")
    EDUCATION("Образование"),

    @SerializedName("Образ жизни")
    @SerialName("Образ жизни")
    LIFESTYLE("Образ жизни"),

    @SerializedName("Шопинг")
    @SerialName("Шопинг")
    SHOPPING("Шопинг"),

    @SerializedName("Новости")
    @SerialName("Новости")
    NEWS("Новости"),

    @SerializedName("Музыка")
    @SerialName("Музыка")
    MUSIC("Музыка"),

    @SerializedName("Игры")
    @SerialName("Игры")
    GAMES("Игры"),

    @SerializedName("Навигация")
    @SerialName("Навигация")
    NAVIGATION("Навигация"),

    @SerializedName("Общение")
    @SerialName("Музыка")
    COMMUNICATION("Музыка"),

    @SerializedName("Бизнес")
    @SerialName("Игры")
    BUSINESS("Игры"),


}