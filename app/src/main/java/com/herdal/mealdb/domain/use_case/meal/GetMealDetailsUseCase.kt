package com.herdal.mealdb.domain.use_case.meal

import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.domain.repository.MealRepository
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    operator fun invoke(mealId: Int): Flow<Resource<MealDetailUiModel>> = flow {
        try {
            emit(Resource.Loading())
            val meal = mealRepository.getMealDetails(mealId)
            Timber.d("$meal")
            emit(Resource.Success(data = meal))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.message))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.message))
        }
    }
}