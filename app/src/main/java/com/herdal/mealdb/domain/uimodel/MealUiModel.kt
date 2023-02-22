package com.herdal.mealdb.domain.uimodel

data class MealUiModel(
    val id: String,
    val name: String,
    val thumbnail: String?,
    var isFavorite: Boolean? = false
)