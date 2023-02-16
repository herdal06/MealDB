package com.herdal.mealdb.presentation.meal_details

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.herdal.mealdb.R
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.databinding.FragmentMealDetailsBinding
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import com.herdal.mealdb.utils.ext.hide
import com.herdal.mealdb.utils.ext.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private var _binding: FragmentMealDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MealDetailsViewModel by viewModels()

    private val navigationArgs: MealDetailsFragmentArgs by navArgs()

    private fun getMealIdArgs() = navigationArgs.mealId

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMealDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        collectMealDetails(getMealIdArgs())
        return view
    }

    private fun collectMealDetails(id: Int) = binding.apply {
        lifecycleScope.launchWhenStarted {
            viewModel.getMealById(id)
            viewModel.meal.collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        tvMealDetailsError.hide()
                        pbMealDetails.hide()
                    }
                    is Resource.Success -> {
                        tvMealDetailsError.hide()
                        pbMealDetails.hide()
                        setupUI(resource.data!!)
                        containerLayout.show()
                    }
                    is Resource.Error -> {
                        tvMealDetailsError.show()
                        pbMealDetails.hide()
                    }
                }
            }
        }
    }

    private fun setupUI(mealDetail: MealDetailUiModel) = binding.apply {
        tvMealNameDetails.text = mealDetail.name
        Glide.with(ivMealDetails).load(mealDetail.thumbnail)
            .centerCrop().into(ivMealDetails)
        tvIngredient1.text = mealDetail.ingredient1
        tvIngredient2.text = mealDetail.ingredient2
        tvIngredient3.text = mealDetail.ingredient3
        tvIngredient4.text = mealDetail.ingredient4
        tvIngredient5.text = mealDetail.ingredient5
        tvInstructions.text = mealDetail.instructions
        tvMealAreaDetails.text = mealDetail.area
        tvMealCategoryDetails.text = mealDetail.category

        ibExpandIngredient.setOnClickListener {
            if (layoutIngredients.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(containerLayout, AutoTransition())
                layoutIngredients.visibility = View.VISIBLE
                ibExpandIngredient.setImageResource(R.drawable.ic_expand_less)
            } else {
                TransitionManager.beginDelayedTransition(containerLayout, AutoTransition())
                layoutIngredients.visibility = View.GONE
                ibExpandIngredient.setImageResource(R.drawable.ic_expand_more)
            }
        }

        ibExpandInstruction.setOnClickListener {
            if (tvInstructions.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(containerLayout, AutoTransition())
                tvInstructions.visibility = View.VISIBLE
                ibExpandInstruction.setImageResource(R.drawable.ic_expand_less)
            } else {
                TransitionManager.beginDelayedTransition(containerLayout, AutoTransition())
                tvInstructions.visibility = View.GONE
                ibExpandInstruction.setImageResource(R.drawable.ic_expand_more)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}