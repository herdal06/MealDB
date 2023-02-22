package com.herdal.mealdb.domain.use_case.meal

import com.herdal.mealdb.domain.repository.MealRepository
import javax.inject.Inject

class IsMealInFavoriteUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    suspend fun execute(mealId: String): Boolean =
        mealRepository.isFavorite(mealId)
}