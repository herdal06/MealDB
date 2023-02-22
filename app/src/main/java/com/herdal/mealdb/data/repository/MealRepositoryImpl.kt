package com.herdal.mealdb.data.repository

import com.herdal.mealdb.common.mapper.meal.MealDtoMapper
import com.herdal.mealdb.common.mapper.meal_details.MealDetailsDtoMapper
import com.herdal.mealdb.data.data_source.MealDataSource
import com.herdal.mealdb.data.local.entity.FavoriteEntity
import com.herdal.mealdb.domain.repository.MealRepository
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import com.herdal.mealdb.domain.uimodel.MealUiModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remote: MealDataSource.Remote,
    private val local: MealDataSource.Local,
    private val mealDtoMapper: MealDtoMapper,
    private val mealDetailDtoMapper: MealDetailsDtoMapper
) : MealRepository {
    override suspend fun getMeals(category: String): List<MealUiModel> {
        return mealDtoMapper.toDomainList(remote.getMeals(category).meals)
    }

    override suspend fun searchMeals(query: String): List<MealUiModel> {
        return mealDtoMapper.toDomainList(remote.searchMeals(query).meals)
    }

    override suspend fun getMealDetails(id: Int): MealDetailUiModel {
        return mealDetailDtoMapper.toDomain(remote.getMealDetails(id).meals[0])
    }

    override suspend fun insertToDb(meal: FavoriteEntity) {
        return local.addToFavorite(meal)
    }

    override fun getAllFavorites(): Flow<List<FavoriteEntity>> {
        return local.getAllFavorites()
    }

    override suspend fun deleteFavoriteMeal(meal: FavoriteEntity) {
        return local.deleteFavorite(meal)
    }

    override suspend fun isFavorite(mealId: String): Boolean {
        return local.isFavorite(mealId)
    }
}