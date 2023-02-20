package com.herdal.mealdb.presentation.search_meals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.domain.use_case.meal.SearchMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchMealsViewModel @Inject constructor(
    private val searchMealsUseCase: SearchMealsUseCase
) : ViewModel() {

    private val _searchedMeals =
        MutableStateFlow<Resource<List<MealUiModel>>>(Resource.Loading())
    val searchedMeals = _searchedMeals.asStateFlow()

    fun searchMeals(searchText: String) {
        searchMealsUseCase(query = searchText)
            .onEach { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _searchedMeals.value = Resource.Loading()
                    }
                    is Resource.Success -> {
                        _searchedMeals.value = resource.data?.let { Resource.Success(it) }!!
                    }
                    is Resource.Error -> {
                        _searchedMeals.value = Resource.Error(resource.message)
                    }
                }
            }.launchIn(viewModelScope)
    }
}