package com.herdal.mealdb.data.remote.dto.category

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryResponse(
    @Json(name = "categories")
    val categories: List<CategoryDto>
)