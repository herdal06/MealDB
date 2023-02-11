package com.herdal.mealdb.data.remote.dto.meal_detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealDetailResponse(
    @Json(name = "meals")
    val meals: List<MealDetailDto>
)