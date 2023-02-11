package com.herdal.mealdb.domain.uimodel

data class MealUiModel(
    val id: String,
    val area: String,
    val category: String,
    val instruction: String,
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val name: String,
    val thumbnail: String,
    val youtubeLink: String
)
