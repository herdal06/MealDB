package com.herdal.mealdb.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.herdal.mealdb.R
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.databinding.FragmentHomeBinding
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.presentation.home.epoxy.CategoryEpoxyController
import com.herdal.mealdb.presentation.home.epoxy.MealEpoxyController
import com.herdal.mealdb.utils.ext.hide
import com.herdal.mealdb.utils.ext.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

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
        lifecycleScope.launchWhenStarted {
            viewModel.getAllCategories()
            viewModel.categories.collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        tvCategoryErrorMessage.hide()
                        rvCategories.hide()
                    }
                    is Resource.Success -> {
                        tvCategoryErrorMessage.hide()
                        pbCategory.hide()
                        rvCategories.show()
                        categoryEpoxyController.setData(resource.data)
                    }
                    is Resource.Error -> {
                        tvCategoryErrorMessage.show()
                        pbCategory.hide()
                        rvCategories.hide()
                    }
                }
            }
        }
    }

    private fun collectMeals() = binding.apply {
        lifecycleScope.launchWhenStarted {
            viewModel.getAllMeals()
            viewModel.meals.collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        tvMealErrorMessage.hide()
                        rvMeals.hide()
                    }
                    is Resource.Success -> {
                        tvMealErrorMessage.hide()
                        pbMeals.hide()
                        rvMeals.show()
                        mealEpoxyController.setData(resource.data)
                    }
                    is Resource.Error -> {
                        tvMealErrorMessage.show()
                        pbMeals.hide()
                        rvMeals.hide()
                    }
                }
            }
        }
    }

    private fun onClickCategory(category: CategoryUiModel) = binding.apply {
        viewModel.category = category.name
        rvMeals.hide()
        collectMeals()
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
        _binding = null
    }
}