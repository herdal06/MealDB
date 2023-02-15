package com.herdal.mealdb.presentation.categories.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.herdal.mealdb.common.base.BaseListAdapter
import com.herdal.mealdb.databinding.ItemCategoryVerticalBinding
import com.herdal.mealdb.domain.uimodel.CategoryUiModel

class CategoryAdapter(
    private val onClickCategory: ((category: CategoryUiModel) -> Unit)?
) : BaseListAdapter<CategoryUiModel>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder =
        CategoryViewHolder(
            ItemCategoryVerticalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onClickCategory
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryViewHolder -> {
                getItem(position)?.let { category -> holder.bind(category) }
            }
        }
    }
}