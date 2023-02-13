package com.herdal.mealdb.data.remote.service

import com.herdal.mealdb.data.remote.dto.category.CategoryResponse
import com.herdal.mealdb.data.remote.utils.ApiConstants
import retrofit2.http.GET

interface CategoryService {

    @GET(ApiConstants.Endpoints.CATEGORIES)
    suspend fun getCategories(): CategoryResponse
}