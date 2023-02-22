package com.herdal.mealdb.presentation.home.epoxy

import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.herdal.mealdb.R
import com.herdal.mealdb.databinding.ItemMealBinding
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.utils.ViewBindingKotlinModel
import com.herdal.mealdb.utils.ext.gone
import com.herdal.mealdb.utils.ext.show

data class MealEpoxyModel(
    val meal: MealUiModel,
    private val onClickMeal: ((mealId: Int) -> Unit)?,
    val onFavoriteIconClicked: (MealUiModel) -> Unit
) : ViewBindingKotlinModel<ItemMealBinding>(R.layout.item_meal) {
    override fun ItemMealBinding.bind() {
        ivMeal.gone()
        tvMealName.gone()
        tvMealName.text = meal.name
        Glide.with(ivMeal).load(meal.thumbnail)
            .centerCrop().into(ivMeal)
        ivMeal.show()
        tvMealName.show()

        root.setOnClickListener { onClickMeal?.let { it1 -> it1(meal.id.toInt()) } }

        imageButton.setOnClickListener { onFavoriteIconClicked.invoke(meal) }

        imageButton.setImageDrawable(
            if (meal.isFavorite == true) {
                ResourcesCompat.getDrawable(
                    imageButton.resources,
                    R.drawable.ic_favorite_essential,
                    null
                )
            } else {
                ResourcesCompat.getDrawable(
                    imageButton.resources,
                    R.drawable.ic_favorite_border_essential,
                    null
                )
            }
        )
    }
}