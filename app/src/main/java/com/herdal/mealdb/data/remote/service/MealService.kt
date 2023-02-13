package com.herdal.mealdb.data.remote.service

import com.herdal.mealdb.data.remote.dto.meal.MealResponse
import com.herdal.mealdb.data.remote.dto.meal_detail.MealDetailResponse
import com.herdal.mealdb.data.remote.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface MealService {

    @GET(ApiConstants.Endpoints.MEALS)
    suspend fun getMeals(
        @Query("c") category: String = "Beef"
    ): MealResponse

    @GET(ApiConstants.Endpoints.SEARCH_MEALS)
    suspend fun searchMeal(
        @Query("s") query: String
    ): MealResponse

    @GET(ApiConstants.Endpoints.MEAL_DETAILS)
    suspend fun getMealDetails(
        @Query("i") id: Int
    ): MealDetailResponse
}