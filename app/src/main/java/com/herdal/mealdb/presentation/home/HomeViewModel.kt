package com.herdal.mealdb.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.domain.use_case.category.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _categories =
        MutableStateFlow<Resource<List<CategoryUiModel>>>(Resource.Loading())
    val categories: StateFlow<Resource<List<CategoryUiModel>>> = _categories

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
}