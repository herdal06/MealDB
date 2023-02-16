package com.herdal.mealdb.domain.use_case.meal

import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.domain.repository.MealRepository
import com.herdal.mealdb.domain.uimodel.MealUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class SearchMealsUseCase @Inject constructor(
    private val mealRepository: MealRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<MealUiModel>>> = flow {
        try {
            emit(Resource.Loading())
            val searchedMeals = mealRepository.searchMeals(query = query)
            Timber.d("$searchedMeals")
            emit(Resource.Success(data = searchedMeals))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.message))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.message))
        }
    }
}