package com.herdal.mealdb.presentation.home.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.herdal.mealdb.domain.uimodel.CategoryUiModel

class CategoryEpoxyController : TypedEpoxyController<List<CategoryUiModel>>() {
    override fun buildModels(data: List<CategoryUiModel>?) {
        if (data == null || data.isEmpty()) {
            return
        }
        data.forEach { category ->
            CategoryEpoxyModel(category).id(category.id).addTo(this)
        }
    }
}