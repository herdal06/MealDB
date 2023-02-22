package com.herdal.mealdb.common.mapper.favorite

import com.herdal.mealdb.common.mapper.Mapper
import com.herdal.mealdb.data.local.entity.FavoriteEntity
import com.herdal.mealdb.domain.uimodel.MealUiModel

class FavoriteEntityMapper : Mapper<FavoriteEntity, MealUiModel> {
    override fun toDomain(t: FavoriteEntity): MealUiModel = MealUiModel(
        id = t.id,
        name = t.name,
        thumbnail = t.thumbnail,
        isFavorite = t.isFavorite
    )

    override fun fromDomain(domainModel: MealUiModel): FavoriteEntity = FavoriteEntity(
        id = domainModel.id,
        name = domainModel.name,
        thumbnail = domainModel.thumbnail,
        isFavorite = domainModel.isFavorite
    )
}