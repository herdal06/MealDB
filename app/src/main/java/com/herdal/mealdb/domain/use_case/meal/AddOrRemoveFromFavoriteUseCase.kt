package com.herdal.mealdb.domain.use_case.meal

import com.herdal.mealdb.common.mapper.favorite.FavoriteEntityMapper
import com.herdal.mealdb.domain.repository.MealRepository
import com.herdal.mealdb.domain.uimodel.MealUiModel
import javax.inject.Inject

class AddOrRemoveFromFavoriteUseCase @Inject constructor(
    private val mealRepository: MealRepository,
    private val isMealInFavoriteUseCase: IsMealInFavoriteUseCase,
    private val favoriteEntityMapper: FavoriteEntityMapper
) {
    suspend fun execute(meal: MealUiModel) {
        if (isMealInFavoriteUseCase.execute(meal.id)) {
            mealRepository.deleteFavoriteMeal(favoriteEntityMapper.fromDomain(meal))
        } else {
            mealRepository.insertToDb(favoriteEntityMapper.fromDomain(meal))
        }
    }
}