package com.herdal.mealdb.data.local.data_source

import com.herdal.mealdb.data.data_source.CategoryDataSource
import com.herdal.mealdb.data.local.dao.CategoryDao
import javax.inject.Inject

class CategoryLocalDataSource @Inject constructor(
    private val categoryDao: CategoryDao
) : CategoryDataSource.Local {
}