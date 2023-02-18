package com.herdal.mealdb.presentation.favorite_meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.herdal.mealdb.databinding.FragmentFavoriteMealsBinding
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.presentation.home.epoxy.MealEpoxyController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMealsFragment : Fragment() {

    private var _binding: FragmentFavoriteMealsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: FavoriteMealsViewModel by viewModels()

    private val favoriteMealsEpoxyController: MealEpoxyController by lazy {
        MealEpoxyController(::onMealClick, ::onFavoriteIconClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteMealsBinding.inflate(inflater, container, false)
        val view = binding.root
        observeFavoriteMeals()
        return view
    }

    private fun observeFavoriteMeals() {
        viewModel.favoriteMeals.observe(viewLifecycleOwner) { meals ->
            meals.let {
                favoriteMealsEpoxyController.setData(it)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEpoxyController()
    }

    private fun setupEpoxyController() = binding.apply {
        rvFavoriteMeals.setController(favoriteMealsEpoxyController)
    }

    private fun onMealClick(mealId: Int) {
        val action =
            FavoriteMealsFragmentDirections.actionFavoriteMealsFragmentToMealDetailsFragment(mealId = mealId)
        findNavController().navigate(action)
    }

    private fun onFavoriteIconClicked(meal: MealUiModel) {
        viewModel.favoriteIconClicked(meal)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvFavoriteMeals.adapter = null
        _binding = null
    }
}