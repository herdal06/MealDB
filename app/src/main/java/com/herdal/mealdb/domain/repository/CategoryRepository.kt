package com.herdal.mealdb.domain.repository

import com.herdal.mealdb.domain.uimodel.CategoryUiModel

interface CategoryRepository {
    suspend fun getCategories(): List<CategoryUiModel>
}