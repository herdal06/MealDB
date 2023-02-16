package com.herdal.mealdb.data.repository

import com.herdal.mealdb.common.mapper.meal.MealDtoMapper
import com.herdal.mealdb.data.data_source.MealDataSource
import com.herdal.mealdb.domain.repository.MealRepository
import com.herdal.mealdb.domain.uimodel.MealUiModel
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    private val remote: MealDataSource.Remote,
    private val mealDtoMapper: MealDtoMapper,
) : MealRepository {
    override suspend fun getMeals(category: String): List<MealUiModel> {
        return mealDtoMapper.toDomainList(remote.getMeals(category).meals)
    }

    override suspend fun searchMeals(query: String): List<MealUiModel> {
        return mealDtoMapper.toDomainList(remote.searchMeals(query).meals)
    }
}