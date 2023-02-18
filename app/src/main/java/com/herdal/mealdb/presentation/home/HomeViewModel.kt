package com.herdal.mealdb.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.domain.use_case.category.GetCategoriesUseCase
import com.herdal.mealdb.domain.use_case.meal.AddOrRemoveFromFavoriteUseCase
import com.herdal.mealdb.domain.use_case.meal.GetMealsUseCase
import com.herdal.mealdb.domain.use_case.meal.IsMealInFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealsUseCase: GetMealsUseCase,
    private val addOrRemoveFromFavoriteUseCase: AddOrRemoveFromFavoriteUseCase,
    private val isMealInFavoriteUseCase: IsMealInFavoriteUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    private val _categories =
        MutableStateFlow<Resource<List<CategoryUiModel>>>(Resource.Loading())
    val categories: StateFlow<Resource<List<CategoryUiModel>>> = _categories

    private val _meals =
        MutableStateFlow<Resource<List<MealUiModel>>>(Resource.Loading())
    val meals: StateFlow<Resource<List<MealUiModel>>> = _meals

    var category: String = "Beef"

    fun getAllCategories() {
        getCategoriesUseCase.invoke()
            .onEach { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _categories.value = Resource.Loading()
                    }
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _categories.value = Resource.Success(resource.data)
                        }
                    }
                    is Resource.Error -> {
                        _categories.value = Resource.Error(resource.message)
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun getAllMeals() {
        getMealsUseCase.invoke(category = category)
            .onEach { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _meals.value = Resource.Loading()
                    }
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _meals.value = Resource.Success(resource.data)
                        }
                    }
                    is Resource.Error -> {
                        _meals.value = Resource.Error(resource.message)
                    }
                }
            }.launchIn(viewModelScope)
    }

    fun favoriteIconClicked(meal: MealUiModel) {
        viewModelScope.launch(dispatcher) {
            addOrRemoveFromFavoriteUseCase.execute(meal)
        }
    }
}