package com.herdal.mealdb.data.remote.dto.category

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryDto(
    @Json(name = "idCategory")
    val idCategory: String,
    @Json(name = "strCategory")
    val strCategory: String,
    @Json(name = "strCategoryDescription")
    val strCategoryDescription: String,
    @Json(name = "strCategoryThumb")
    val strCategoryThumb: String
)