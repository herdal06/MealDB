package com.herdal.mealdb.domain.repository

import com.herdal.mealdb.data.local.entity.FavoriteEntity
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import com.herdal.mealdb.domain.uimodel.MealUiModel
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun getMeals(category: String): List<MealUiModel>
    suspend fun searchMeals(query: String): List<MealUiModel>
    suspend fun getMealDetails(id: Int): MealDetailUiModel
    suspend fun insertToDb(meal: FavoriteEntity)
    fun getAllFavorites(): Flow<List<FavoriteEntity>>
    suspend fun deleteFavoriteMeal(meal: FavoriteEntity)
    suspend fun isFavorite(mealId : String) : Boolean
}