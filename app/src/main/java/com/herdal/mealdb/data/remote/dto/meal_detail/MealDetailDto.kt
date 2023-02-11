package com.herdal.mealdb.data.remote.dto.meal_detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealDetailDto(
    @Json(name = "idMeal")
    val idMeal: String,
    @Json(name = "strArea")
    val strArea: String,
    @Json(name = "strCategory")
    val strCategory: String,
    @Json(name = "strInstructions")
    val strInstructions: String,
    @Json(name = "strIngredient1")
    val strIngredient1: String,
    @Json(name = "strIngredient2")
    val strIngredient2: String,
    @Json(name = "strIngredient3")
    val strIngredient3: String,
    @Json(name = "strIngredient4")
    val strIngredient4: String,
    @Json(name = "strIngredient5")
    val strIngredient5: String,
    @Json(name = "strMeal")
    val strMeal: String,
    @Json(name = "strMealThumb")
    val strMealThumb: String,
    @Json(name = "strYoutube")
    val strYoutube: String
)