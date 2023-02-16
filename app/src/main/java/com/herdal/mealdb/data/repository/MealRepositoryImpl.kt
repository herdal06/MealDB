package com.herdal.mealdb.data.repository

import com.herdal.mealdb.common.mapper.meal.MealDtoMapper
import com.herdal.mealdb.common.mapper.meal_details.MealDetailsDtoMapper
import com.herdal.mealdb.data.data_source.MealDataSource
import com.herdal.mealdb.domain.repository.MealRepository
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import com.herdal.mealdb.domain.uimodel.MealUiModel
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remote: MealDataSource.Remote,
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
}