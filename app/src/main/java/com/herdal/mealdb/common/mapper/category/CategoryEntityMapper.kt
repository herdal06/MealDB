package com.herdal.mealdb.common.mapper.category

import com.herdal.mealdb.common.mapper.Mapper
import com.herdal.mealdb.data.local.entity.CategoryEntity
import com.herdal.mealdb.domain.uimodel.CategoryUiModel

class CategoryEntityMapper : Mapper<CategoryEntity, CategoryUiModel> {
    override fun toDomain(t: CategoryEntity): CategoryUiModel = CategoryUiModel(
        id = t.id,
        name = t.name,
        description = t.description,
        thumbnail = t.thumbnail
    )

    override fun fromDomain(domainModel: CategoryUiModel): CategoryEntity = CategoryEntity(
        id = domainModel.id,
        name = domainModel.name,
        description = domainModel.description,
        thumbnail = domainModel.thumbnail
    )

    fun toDomainList(entities: List<CategoryEntity>): List<CategoryUiModel> =
        entities.map { categoryEntity ->
            toDomain(categoryEntity)
        }

    fun fromDomainList(domainList: List<CategoryUiModel>): List<CategoryEntity> =
        domainList.map { domainList ->
            fromDomain(domainList)
        }

}