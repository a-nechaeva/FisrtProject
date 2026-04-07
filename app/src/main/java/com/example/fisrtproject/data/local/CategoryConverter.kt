package com.example.fisrtproject.data.local

import androidx.room.TypeConverter
import com.example.fisrtproject.domain.model.Category

class CategoryConverter {
    @TypeConverter
    fun fromCategory(category: Category): String = category.name

    @TypeConverter
    fun toCategory(categoryName: String): Category = Category.valueOf(categoryName)
}