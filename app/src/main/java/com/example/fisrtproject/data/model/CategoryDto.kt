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

    @SerializedName("Еда и напитки")
    @SerialName("Еда и напитки")
    FOOD("Еда и напитки"),

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
    @SerialName("Общение")
    COMMUNICATION("Общение"),

    @SerializedName("Бизнес")
    @SerialName("Бизнес")
    BUSINESS("Бизнес"),

    @SerializedName("Погода")
    @SerialName("Погода")
    WEATHER("Погода"),

    @SerializedName("Развлечения")
    @SerialName("Развлечения")
    ENTERTAINMENT("Развлечения"),

    @SerializedName("Книги и справочники")
    @SerialName("Книги и справочники")
    BOOKS("Книги и справочники"),


}