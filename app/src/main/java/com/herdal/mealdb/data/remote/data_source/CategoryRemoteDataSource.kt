package com.herdal.mealdb.data.remote.data_source

import com.herdal.mealdb.data.data_source.CategoryDataSource
import com.herdal.mealdb.data.remote.dto.category.CategoryResponse
import com.herdal.mealdb.data.remote.service.CategoryService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRemoteDataSource @Inject constructor(
    private val categoryService: CategoryService,
    private val ioDispatcher: CoroutineDispatcher
) : CategoryDataSource.Remote {
    override suspend fun getCategories(): CategoryResponse =
        withContext(ioDispatcher) {
            categoryService.getCategories()
        }
}