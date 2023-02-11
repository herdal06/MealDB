package com.herdal.mealdb.data.remote.dto.meal

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealResponse(
    @Json(name = "meals")
    val meals: List<MealDto>
)