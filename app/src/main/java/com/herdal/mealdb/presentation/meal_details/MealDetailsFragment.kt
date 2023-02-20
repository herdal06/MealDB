package com.herdal.mealdb.presentation.meal_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.herdal.mealdb.R
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.databinding.FragmentMealDetailsBinding
import com.herdal.mealdb.domain.uimodel.MealDetailUiModel
import com.herdal.mealdb.utils.ext.collectLatestLifecycleFlow
import com.herdal.mealdb.utils.ext.errorState
import com.herdal.mealdb.utils.ext.loadingState
import com.herdal.mealdb.utils.ext.successState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMealDetailsBinding

    private val viewModel: MealDetailsViewModel by viewModels()

    private val navigationArgs: MealDetailsFragmentArgs by navArgs()

    private fun getMealIdArgs() = navigationArgs.mealId

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_meal_details, container, false)
        val view = binding.root
        collectMealDetails(getMealIdArgs())
        return view
    }

    private fun collectMealDetails(id: Int) = binding.apply {
        viewModel.getMealById(id)
        collectLatestLifecycleFlow(viewModel.meal) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    loadingState(tvMealDetailsError,pbMealDetails)
                }
                is Resource.Success -> {
                    successState(tvMealDetailsError,pbMealDetails)
                    setupUI(resource.data!!)
                }
                is Resource.Error -> {
                    errorState(tvMealDetailsError,pbMealDetails)
                }
            }
        }
    }

    private fun setupUI(mealDetail: MealDetailUiModel) = binding.apply {
        binding.mealDetail = mealDetail
    }
}