package com.herdal.mealdb.data.data_source

import com.herdal.mealdb.data.local.entity.FavoriteEntity
import com.herdal.mealdb.data.remote.dto.meal.MealResponse
import com.herdal.mealdb.data.remote.dto.meal_detail.MealDetailResponse
import kotlinx.coroutines.flow.Flow

interface MealDataSource {
    interface Remote {
        suspend fun getMeals(category: String): MealResponse
        suspend fun searchMeals(query: String): MealResponse
        suspend fun getMealDetails(id: Int): MealDetailResponse
    }

    interface Local {
        suspend fun addToFavorite(favorite: FavoriteEntity)
        fun getAllFavorites(): Flow<List<FavoriteEntity>>
        suspend fun deleteFavorite(favorite: FavoriteEntity)
        suspend fun isFavorite(mealId: String): Boolean
    }
}