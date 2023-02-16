package com.herdal.mealdb.domain.repository

import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import com.herdal.mealdb.domain.uimodel.MealUiModel

interface MealRepository {
    suspend fun getMeals(category: String): List<MealUiModel>
    suspend fun searchMeals(query: String): List<MealUiModel>
    suspend fun getMealDetails(id: Int): MealDetailUiModel
}