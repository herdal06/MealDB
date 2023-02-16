package com.herdal.mealdb.data.data_source

import com.herdal.mealdb.data.remote.dto.meal.MealResponse
import com.herdal.mealdb.data.remote.dto.meal_detail.MealDetailResponse

interface MealDataSource {
    interface Remote {
        suspend fun getMeals(category: String): MealResponse
        suspend fun searchMeals(query: String): MealResponse
        suspend fun getMealDetails(id: Int): MealDetailResponse
    }

    interface Local {
    }
}