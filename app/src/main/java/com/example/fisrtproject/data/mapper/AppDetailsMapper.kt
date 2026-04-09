package com.example.fisrtproject.data.mapper

import com.example.fisrtproject.data.model.AppDetailsDto
import com.example.fisrtproject.domain.model.AppDetails
import com.example.fisrtproject.domain.model.Category
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDetailsMapper @Inject constructor() {

    fun toDomain(dto: AppDetailsDto): AppDetails {
        return AppDetails(
            id = dto.id,
            name = dto.name,
            developer = dto.developer?.takeIf { it.isNotEmpty() } ?: "Неизвестный разработчик",
            category = dto.category.toCategoryDomain(),
            ageRating = dto.ageRating ?: 0,
            size = dto.size?.toFloat() ?: 0f,
            iconUrl = dto.iconUrl,
            screenshotUrlList = dto.screenshotUrlList,
            description = dto.description
        )
    }

    private fun String.toCategoryDomain(): Category {
        return when (this) {
            "Финансы" -> Category.FINANCE
            "Транспорт" -> Category.TRAVEL
            "Утилиты" -> Category.UTILITIES
            "Производительность" -> Category.PRODUCTIVITY
            "Здоровье и фитнес" -> Category.HEALTH
            "Фото и видео" -> Category.PHOTO
            "Еда и напитки" -> Category.FOOD
            "Образование" -> Category.EDUCATION
            "Образ жизни" -> Category.LIFESTYLE
            "Шопинг" -> Category.SHOPPING
            "Новости" -> Category.NEWS
            "Музыка" -> Category.MUSIC
            "Игры" -> Category.GAMES
            "Навигация" -> Category.NAVIGATION
            "Общение" -> Category.COMMUNICATION
            "Бизнес" -> Category.BUSINESS
            "Погода" -> Category.WEATHER
            "Развлечения" -> Category.ENTERTAINMENT
            "Книги и справочники" -> Category.BOOKS
            else -> Category.OTHER
        }
    }
}