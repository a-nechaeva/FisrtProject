package com.example.fisrtproject.data.mapper

import com.example.fisrtproject.data.model.AppDetailsDto
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.model.Category

object AppMapper {

    fun toDomain(dto: AppDetailsDto): App {
        return App(
            id = dto.id,
            name = dto.name,
            developer = dto.developer?.takeIf { it.isNotEmpty() } ?: "Неизвестный разработчик",
            category = dto.category.toCategoryDomain(),
            ageRating = dto.ageRating,
            size = dto.size,
            iconUrl = dto.iconUrl,
            screenshots = dto.screenshotUrlList,
            description = dto.description
        )
    }

    fun toDomainList(dtos: List<AppDetailsDto>): List<App> {
        return dtos.map { toDomain(it) }
    }

    private fun String.toCategoryDomain(): Category {
        return when (this) {
            "Финансы" -> Category.FINANCE
            "Транспорт" -> Category.TRAVEL
            "Утилиты" -> Category.UTILITIES
            "Производительность" -> Category.PRODUCTIVITY
            "Здоровье и фитнес" -> Category.HEALTH
            "Фото и видео" -> Category.PHOTO
            "Еда и Напитки" -> Category.FOOD
            "Образование" -> Category.EDUCATION
            "Образ жизни" -> Category.LIFESTYLE
            "Шопинг" -> Category.SHOPPING
            "Новости" -> Category.NEWS
            "Музыка" -> Category.MUSIC
            "Игры" -> Category.GAMES
            "Навигация" -> Category.NAVIGATION

            else -> Category.OTHER
        }
    }
}