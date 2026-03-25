package com.example.fisrtproject.data.model

import com.google.gson.annotations.SerializedName

data class AppDetailsDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("developer")
    val developer: String? = null,

    @SerializedName("category")
    val category: String,

    @SerializedName("ageRating")
    val ageRating: Int? = null,

    @SerializedName("size")
    val size: Double? = null,

    @SerializedName("iconUrl")
    val iconUrl: String,

    @SerializedName("screenshotUrlList")
    val screenshotUrlList: List<String>? = null,

    @SerializedName("description")
    val description: String
)