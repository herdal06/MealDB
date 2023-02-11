package com.herdal.mealdb.data.remote.dto.meal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealDto(
    @Json(name = "idMeal")
    val idMeal: String,
    @Json(name = "strMeal")
    val strMeal: String,
    @Json(name = "strMealThumb")
    val strMealThumb: String
)