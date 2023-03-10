package com.herdal.mealdb.presentation.home.epoxy

import com.bumptech.glide.Glide
import com.herdal.mealdb.R
import com.herdal.mealdb.databinding.ItemCategoryBinding
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.utils.ViewBindingKotlinModel
import com.herdal.mealdb.utils.ext.gone
import com.herdal.mealdb.utils.ext.show

data class CategoryEpoxyModel(
    val category: CategoryUiModel,
    private val onClickCategory: ((category: CategoryUiModel) -> Unit)?
) : ViewBindingKotlinModel<ItemCategoryBinding>(R.layout.item_category) {
    override fun ItemCategoryBinding.bind() {
        pbCategoryItem.show()
        ivCategory.gone()
        tvCategoryName.gone()
        tvCategoryName.text = category.name
        Glide.with(ivCategory).load(category.thumbnail)
            .centerCrop().into(ivCategory)
        pbCategoryItem.gone()
        ivCategory.show()
        tvCategoryName.show()

        root.setOnClickListener {
            onClickCategory?.invoke(category)
        }
    }
}