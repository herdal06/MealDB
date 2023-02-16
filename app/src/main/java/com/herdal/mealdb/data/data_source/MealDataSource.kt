package com.herdal.mealdb.data.data_source

import com.herdal.mealdb.data.remote.dto.meal.MealResponse

interface MealDataSource {
    interface Remote {
        suspend fun getMeals(category: String): MealResponse
        suspend fun searchMeals(query: String): MealResponse
    }

    interface Local {
    }
}