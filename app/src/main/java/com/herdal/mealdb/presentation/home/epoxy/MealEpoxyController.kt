package com.herdal.mealdb.presentation.home.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.herdal.mealdb.domain.uimodel.MealUiModel

class MealEpoxyController : TypedEpoxyController<List<MealUiModel>>() {
    override fun buildModels(data: List<MealUiModel>?) {
        if (data == null || data.isEmpty()) {
            return
        }
        data.forEach { meal ->
            MealEpoxyModel(meal).id(meal.id).addTo(this)
        }
    }
}