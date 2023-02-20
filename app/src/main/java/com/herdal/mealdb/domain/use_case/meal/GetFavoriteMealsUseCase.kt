package com.herdal.mealdb.domain.use_case.meal

import com.herdal.mealdb.common.mapper.favorite.FavoriteEntityMapper
import com.herdal.mealdb.domain.repository.MealRepository
import com.herdal.mealdb.domain.uimodel.MealUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetFavoriteMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository,
    private val favoriteEntityMapper: FavoriteEntityMapper
) {
    operator fun invoke(): Flow<List<MealUiModel>> {
        val favorites = mealRepository.getAllFavorites()
        return favorites.map {
            it.map { favoriteEntity ->
                favoriteEntityMapper.toDomain(favoriteEntity)
            }
        }
    }
}