package com.herdal.mealdb.presentation.meal_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import com.herdal.mealdb.domain.use_case.meal.GetMealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    private val getMealDetailsUseCase: GetMealDetailsUseCase
) : ViewModel() {

    private val _meal =
        MutableStateFlow<Resource<MealDetailUiModel>>(Resource.Loading())
    val meal: StateFlow<Resource<MealDetailUiModel>> = _meal

    fun getMealById(id: Int) {
        getMealDetailsUseCase.invoke(id)
            .onEach { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _meal.value = Resource.Loading()
                    }
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _meal.value = Resource.Success(resource.data)
                        }
                    }
                    is Resource.Error -> {
                        _meal.value = Resource.Error(resource.message)
                    }
                }
            }.launchIn(viewModelScope)
    }
}