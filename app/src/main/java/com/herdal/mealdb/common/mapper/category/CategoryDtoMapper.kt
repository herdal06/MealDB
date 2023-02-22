package com.herdal.mealdb.common.mapper.category

import com.herdal.mealdb.common.mapper.Mapper
import com.herdal.mealdb.data.remote.dto.category.CategoryDto
import com.herdal.mealdb.domain.uimodel.CategoryUiModel

class CategoryDtoMapper : Mapper<CategoryDto, CategoryUiModel> {
    override fun toDomain(t: CategoryDto): CategoryUiModel = CategoryUiModel(
        id = t.idCategory,
        name = t.strCategory,
        description = t.strCategoryDescription,
        thumbnail = t.strCategoryThumb
    )

    override fun fromDomain(domainModel: CategoryUiModel): CategoryDto = CategoryDto(
        idCategory = domainModel.id,
        strCategory = domainModel.name,
        strCategoryDescription = domainModel.description,
        strCategoryThumb = domainModel.thumbnail
    )

    fun toDomainList(dtos: List<CategoryDto>): List<CategoryUiModel> =
        dtos.map { categoryEntity ->
            toDomain(categoryEntity)
        }
}