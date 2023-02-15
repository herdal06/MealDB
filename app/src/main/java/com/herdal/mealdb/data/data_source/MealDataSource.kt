package com.herdal.mealdb.data.data_source

import com.herdal.mealdb.data.remote.dto.meal.MealResponse

interface MealDataSource {
    interface Remote {
        suspend fun getMeals(): MealResponse
    }

    interface Local {
    }
}