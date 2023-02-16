package com.herdal.mealdb.presentation.meal_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
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
        binding.mealDetail = mealDetail
    }
}