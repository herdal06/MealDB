package com.herdal.mealdb.presentation.categories.adapter

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.herdal.mealdb.R
import com.herdal.mealdb.databinding.ItemCategoryVerticalBinding
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.utils.ext.executeWithAction

class CategoryViewHolder(
    private val binding: ItemCategoryVerticalBinding,
    private val onClickCategory: ((category: CategoryUiModel) -> Unit)?
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(category: CategoryUiModel) = binding.apply {
        binding.executeWithAction {
            this.category = category
        }

        itemView.setOnClickListener {
            onClickCategory?.invoke(category)
        }

        ibExpand.setOnClickListener {
            if (tvCategoryDescription.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardViewCategories, AutoTransition())
                tvCategoryDescription.visibility = View.VISIBLE
                ibExpand.setImageResource(R.drawable.ic_expand_less)
            } else {
                TransitionManager.beginDelayedTransition(cardViewCategories, AutoTransition())
                tvCategoryDescription.visibility = View.GONE
                ibExpand.setImageResource(R.drawable.ic_expand_more)
            }
        }
    }
}