package com.herdal.mealdb.data.repository

import com.herdal.mealdb.common.mapper.category.CategoryDtoMapper
import com.herdal.mealdb.data.data_source.CategoryDataSource
import com.herdal.mealdb.domain.repository.CategoryRepository
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import javax.inject.Inject

/**
 * Repository for fetching categories from the network and storing them on disk
 */
class CategoryRepositoryImpl @Inject constructor(
    private val remote: CategoryDataSource.Remote,
    private val categoryDtoMapper: CategoryDtoMapper,
) : CategoryRepository {

    override suspend fun getCategories(): List<CategoryUiModel> {
        return categoryDtoMapper.toDomainList(remote.getCategories().categories)
    }
}