package com.herdal.mealdb.domain.uimodel

data class MealDetailUiModel(
    val id: Int,
    val area: String,
    val category: String,
    val instructions: String,
    val ingredient1: String,
    val ingredient2: String,
    val ingredient3: String,
    val ingredient4: String,
    val ingredient5: String,
    val name: String,
    val thumbnail: String,
    val youtubeLink: String
)