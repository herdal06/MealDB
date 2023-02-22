package com.herdal.mealdb.common.mapper.meal

import com.herdal.mealdb.common.mapper.Mapper
import com.herdal.mealdb.data.remote.dto.meal.MealDto
import com.herdal.mealdb.domain.uimodel.MealUiModel

class MealDtoMapper : Mapper<MealDto, MealUiModel> {
    override fun toDomain(t: MealDto): MealUiModel = MealUiModel(
        id = t.idMeal,
        name = t.strMeal,
        thumbnail = t.strMealThumb
    )

    override fun fromDomain(domainModel: MealUiModel): MealDto = MealDto(
        idMeal = domainModel.id,
        strMeal = domainModel.name,
        strMealThumb = domainModel.thumbnail
    )

    fun toDomainList(dtos: List<MealDto>): List<MealUiModel> =
        dtos.map { mealDto ->
            toDomain(mealDto)
        }
}