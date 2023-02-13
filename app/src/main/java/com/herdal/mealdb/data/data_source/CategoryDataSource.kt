package com.herdal.mealdb.data.data_source

import com.herdal.mealdb.data.local.entity.CategoryEntity
import com.herdal.mealdb.data.remote.dto.category.CategoryResponse
import kotlinx.coroutines.flow.Flow

interface CategoryDataSource {
    interface Remote {
        suspend fun getCategories(): CategoryResponse
    }

    interface Local {
        fun getAll(): Flow<List<CategoryEntity>>
        suspend fun insert(category: CategoryEntity)
        suspend fun insertAll(categories: List<CategoryEntity>)
    }
}