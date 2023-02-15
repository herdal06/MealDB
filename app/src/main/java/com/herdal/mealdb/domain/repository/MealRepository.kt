package com.herdal.mealdb.domain.repository

import com.herdal.mealdb.domain.uimodel.MealUiModel

interface MealRepository {
    suspend fun getMeals(category: String): List<MealUiModel>
}