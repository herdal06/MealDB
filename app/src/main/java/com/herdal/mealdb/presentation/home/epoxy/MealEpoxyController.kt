package com.herdal.mealdb.presentation.home.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.herdal.mealdb.domain.uimodel.MealUiModel

class MealEpoxyController(
    private val onClickMeal: ((mealId: Int) -> Unit)?,
    private val onFavoriteIconClicked: (MealUiModel) -> Unit,

    ) : TypedEpoxyController<List<MealUiModel>>() {
    override fun buildModels(data: List<MealUiModel>?) {
        if (data == null || data.isEmpty()) {
            return
        }
        data.forEach { meal ->
            MealEpoxyModel(meal, onClickMeal,onFavoriteIconClicked).id(meal.id).addTo(this)
        }
    }
}