package com.herdal.mealdb.data.local.data_source

import com.herdal.mealdb.data.data_source.CategoryDataSource
import com.herdal.mealdb.data.local.dao.CategoryDao
import com.herdal.mealdb.data.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryLocalDataSource @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryDataSource.Local {
    override fun getAll(): Flow<List<CategoryEntity>> = categoryDao.getAll()

    override suspend fun insert(category: CategoryEntity) = categoryDao.insert(category)

    override suspend fun insertAll(categories: List<CategoryEntity>) =
        categoryDao.insertAll(categories)
}