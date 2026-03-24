package com.example.fisrtproject.data.mapper

import com.example.fisrtproject.data.model.AppDetailsDto
import com.example.fisrtproject.data.model.CategoryDto
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.model.Category

object AppMapper {
    fun toDomain(dto: AppDetailsDto): App {
        return App(
            id = dto.id,
            name = dto.name,
            developer = dto.developer,
            category = dto.category.toCategoryDomain(),
            ageRating = dto.ageRating,
            size = dto.size,
            icon = dto.icon,
            screenshots = dto.screenshots,
            description = dto.description
        )
    }

    fun toDomainList(dtos: List<AppDetailsDto>): List<App> {
        return dtos.map { toDomain(it) }
    }

    private fun CategoryDto.toCategoryDomain(): Category {
        return when (this) {
            CategoryDto.FINANCE -> Category.FINANCE
            CategoryDto.TRAVEL -> Category.TRAVEL
            CategoryDto.UTILITIES -> Category.UTILITIES
        }
    }
}