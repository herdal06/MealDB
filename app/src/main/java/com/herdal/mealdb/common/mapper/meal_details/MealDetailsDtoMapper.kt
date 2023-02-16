package com.herdal.mealdb.common.mapper.meal_details

import com.herdal.mealdb.common.mapper.Mapper
import com.herdal.mealdb.data.remote.dto.meal_detail.MealDetailDto
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel

class MealDetailsDtoMapper : Mapper<MealDetailDto, MealDetailUiModel> {
    override fun toDomain(t: MealDetailDto): MealDetailUiModel = MealDetailUiModel(
        id = t.idMeal.toInt(),
        area = t.strArea,
        category = t.strCategory,
        instructions = t.strInstructions,
        ingredient1 = t.strIngredient1,
        ingredient2 = t.strIngredient2,
        ingredient3 = t.strIngredient3,
        ingredient4 = t.strIngredient4,
        ingredient5 = t.strIngredient5,
        name = t.strMeal,
        thumbnail = t.strMealThumb,
        youtubeLink = t.strYoutube
    )

    override fun fromDomain(domainModel: MealDetailUiModel): MealDetailDto = MealDetailDto(
        idMeal = domainModel.id.toString(),
        strArea = domainModel.area,
        strCategory = domainModel.category,
        strInstructions = domainModel.instructions,
        strIngredient1 = domainModel.ingredient1,
        strIngredient2 = domainModel.ingredient2,
        strIngredient3 = domainModel.ingredient3,
        strIngredient4 = domainModel.ingredient4,
        strIngredient5 = domainModel.ingredient5,
        strMeal = domainModel.name,
        strMealThumb = domainModel.thumbnail,
        strYoutube = domainModel.youtubeLink
    )
}