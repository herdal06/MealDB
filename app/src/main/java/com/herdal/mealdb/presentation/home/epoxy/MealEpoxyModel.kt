package com.herdal.mealdb.presentation.home.epoxy

import com.bumptech.glide.Glide
import com.herdal.mealdb.R
import com.herdal.mealdb.databinding.ItemMealBinding
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.utils.ViewBindingKotlinModel
import com.herdal.mealdb.utils.ext.hide
import com.herdal.mealdb.utils.ext.show

data class MealEpoxyModel(
    val meal: MealUiModel,
    private val onClickMeal: ((mealId: Int) -> Unit)?
) : ViewBindingKotlinModel<ItemMealBinding>(R.layout.item_meal) {
    override fun ItemMealBinding.bind() {
        ivMeal.hide()
        tvMealName.hide()
        tvMealName.text = meal.name
        Glide.with(ivMeal).load(meal.thumbnail)
            .centerCrop().into(ivMeal)
        ivMeal.show()
        tvMealName.show()

        root.setOnClickListener { onClickMeal?.let { it1 -> it1(meal.id.toInt()) } }
    }
}