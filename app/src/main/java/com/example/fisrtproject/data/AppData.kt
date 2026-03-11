package com.example.fisrtproject.data

import com.example.fisrtproject.R

object AppData {
    val appList = listOf(
        AppDetailsDto(
            id = "1",
            name = "СберБанк Онлайн - с Салютом",
            developer = "",
            category = Category.FINANCE,
            ageRating = 14,
            size = 85.5,
            icon = R.drawable.sber, // svg использовать
            screenshots = listOf(), //png сделать библиотеку с картинками из сети, а не из памяти
            description = "Больше чем банк"
        ),
        AppDetailsDto(
            id = "2",
            name = "Яндекс.Браузер — с Алисой",
            developer = "",
            category = Category.UTILITIES,
            ageRating = 14,
            size = 85.5,
            icon = R.drawable.yandex_br,
            screenshots = listOf(),
            description = "Быстрый и безопасный браузер",
        ),
        AppDetailsDto(
            id = "3",
            name = "Почта Mail.ru",
            developer = "",
            category = Category.UTILITIES,
            ageRating = 14,
            size = 85.5,
            icon = R.drawable.mailru,
            screenshots = listOf(),
            description = "Почтовый клиент для любых ящиков"
        ),
        AppDetailsDto(
            id = "4",
            name = "Яндекс Навигатор",
            developer = "",
            category = Category.TRAVEL,
            ageRating = 14,
            size = 85.5,
            icon = R.drawable.navigator,
            screenshots = listOf(),
            description = "Парковки и заправки — по пути"
        ),
        AppDetailsDto(
            id = "5",
            name = "Мой МТС",
            developer = "",
            category = Category.UTILITIES,
            ageRating = 14,
            size = 85.5,
            icon = R.drawable.mts,
            screenshots = listOf(),
            description = "Мой МТС — центр экосистемы МТС"
        ),
        AppDetailsDto(
            id = "6",
            name = "Яндекс — с Алисой",
            developer = "",
            category = Category.UTILITIES,
            ageRating = 14,
            size = 85.5,
            icon = R.drawable.yandex,
            screenshots = listOf(),
            description = "Яндекс — поиск всегда под рукой"
        )
    )

    fun getAppById(id: String): AppDetailsDto? {
        return appList.find { it.id == id }
    }
}