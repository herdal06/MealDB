package com.herdal.mealdb.presentation.favorite_meals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.domain.use_case.meal.AddOrRemoveFromFavoriteUseCase
import com.herdal.mealdb.domain.use_case.meal.GetFavoriteMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMealsViewModel @Inject constructor(
    getFavoriteMealsUseCase: GetFavoriteMealsUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main,
    private val addOrRemoveFromFavoriteUseCase: AddOrRemoveFromFavoriteUseCase
) : ViewModel() {
    val favoriteMeals: LiveData<List<MealUiModel>> =
        getFavoriteMealsUseCase.invoke().asLiveData()

    fun favoriteIconClicked(meal: MealUiModel) {
        viewModelScope.launch(dispatcher) {
            addOrRemoveFromFavoriteUseCase.execute(meal)
        }
    }
}
