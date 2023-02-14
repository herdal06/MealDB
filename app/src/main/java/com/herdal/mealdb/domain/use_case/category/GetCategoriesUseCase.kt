package com.herdal.mealdb.domain.use_case.category

import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.domain.repository.CategoryRepository
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    operator fun invoke(): Flow<Resource<List<CategoryUiModel>>> = flow {
        try {
            emit(Resource.Loading())
            val categories= categoryRepository.getCategories()
            Timber.d("$categories")
            emit(Resource.Success(data = categories))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.message))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.message))
        }
    }
}