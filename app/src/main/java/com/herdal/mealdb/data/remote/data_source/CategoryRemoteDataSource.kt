package com.herdal.mealdb.data.remote.data_source

import com.herdal.mealdb.data.data_source.CategoryDataSource
import com.herdal.mealdb.data.remote.service.CategoryService
import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor(
    private val categoryService: CategoryService
) : CategoryDataSource.Remote {
}