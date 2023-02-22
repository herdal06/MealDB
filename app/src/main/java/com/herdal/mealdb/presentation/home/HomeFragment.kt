package com.herdal.mealdb.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.herdal.mealdb.R
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.databinding.FragmentHomeBinding
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.presentation.home.epoxy.CategoryEpoxyController
import com.herdal.mealdb.presentation.home.epoxy.MealEpoxyController
import com.herdal.mealdb.utils.ext.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val categoryEpoxyController: CategoryEpoxyController by lazy {
        CategoryEpoxyController(::onClickCategory)
    }

    private val mealEpoxyController: MealEpoxyController by lazy {
        MealEpoxyController(::onMealClick, ::onFavoriteIconClicked)
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        collectCategories()
        collectMeals()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEpoxyController()
        goToCategoriesScreen()
    }

    private fun goToCategoriesScreen() = binding.apply {
        tvSeeAllCategories.setOnClickListener {
            findNavController().navigate(R.id.categoriesFragment)
        }
    }

    private fun setupEpoxyController() = binding.apply {
        rvCategories.setController(categoryEpoxyController)
        rvMeals.setController(mealEpoxyController)
    }

    private fun collectCategories() = binding.apply {
        viewModel.getAllCategories()
        collectLatestLifecycleFlow(viewModel.categories) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    loadingState(tvCategoryErrorMessage, pbCategory, rvCategories)
                }
                is Resource.Success -> {
                    successState(tvCategoryErrorMessage, pbCategory, rvCategories)
                    categoryEpoxyController.setData(resource.data)
                }
                is Resource.Error -> {
                    errorState(tvCategoryErrorMessage, pbCategory, rvCategories)
                }
            }
        }
    }

    private fun collectMeals() = binding.apply {
        viewModel.getAllMeals()
        collectLatestLifecycleFlow(viewModel.meals) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    loadingState(tvCategoryErrorMessage, pbCategory, rvCategories)
                }
                is Resource.Success -> {
                    successState(tvCategoryErrorMessage, pbCategory, rvCategories)
                    mealEpoxyController.setData(resource.data)
                }
                is Resource.Error -> {
                    errorState(tvCategoryErrorMessage, pbCategory, rvCategories)
                }
            }
        }
    }

    private fun changeCategoryName(categoryName: String) = binding.apply {
        tvCategoryMeal.text = categoryName
    }

    private fun onClickCategory(category: CategoryUiModel) = binding.apply {
        viewModel.category = category.name
        rvMeals.gone()
        collectMeals()
        changeCategoryName(category.name)
        rvMeals.show()
    }

    private fun onMealClick(mealId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToMealDetailsFragment(mealId = mealId)
        findNavController().navigate(action)
    }

    private fun onFavoriteIconClicked(meal: MealUiModel) {
        viewModel.favoriteIconClicked(meal)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvCategories.adapter = null
        binding.rvMeals.adapter = null
        categoryEpoxyController.setData(emptyList())
        mealEpoxyController.setData(emptyList())
        _binding = null
    }
}