package com.herdal.mealdb.data.remote.data_source

import com.herdal.mealdb.data.data_source.MealDataSource
import com.herdal.mealdb.data.remote.dto.meal.MealResponse
import com.herdal.mealdb.data.remote.service.MealService
import com.herdal.mealdb.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealRemoteDataSource @Inject constructor(
    private val mealService: MealService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MealDataSource.Remote {
    override suspend fun getMeals(category: String): MealResponse =
        withContext(ioDispatcher) {
            mealService.getMeals(category)
        }

    override suspend fun searchMeals(query: String): MealResponse =
        withContext(ioDispatcher) {
            mealService.searchMeals(query)
        }
}