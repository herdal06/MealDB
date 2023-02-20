package com.herdal.mealdb.presentation.search_meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.databinding.FragmentSearchMealsBinding
import com.herdal.mealdb.domain.uimodel.MealUiModel
import com.herdal.mealdb.presentation.home.epoxy.MealEpoxyController
import com.herdal.mealdb.utils.ext.collectLatestLifecycleFlow
import com.herdal.mealdb.utils.ext.errorState
import com.herdal.mealdb.utils.ext.loadingState
import com.herdal.mealdb.utils.ext.successState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMealsFragment : Fragment() {

    private var _binding: FragmentSearchMealsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val mealEpoxyController: MealEpoxyController by lazy {
        MealEpoxyController(::onMealClick, ::onFavoriteIconClicked)
    }

    private val viewModel: SearchMealsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMealsBinding.inflate(inflater, container, false)
        val view = binding.root
        setupSearchView()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEpoxyController()
    }

    private fun searchMeals(searchText: String) = binding.apply {
        viewModel.searchMeals(searchText)
        collectLatestLifecycleFlow(viewModel.searchedMeals) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    loadingState(tvSearchError,pbSearch,rvSearchedMeals)
                }
                is Resource.Success -> {
                    successState(tvSearchError,pbSearch,rvSearchedMeals)
                    mealEpoxyController.setData(resource.data)
                }
                is Resource.Error -> {
                    errorState(tvSearchError,pbSearch,rvSearchedMeals)
                }
            }
        }
    }

    private fun setupSearchView() = binding.svMeals.setOnQueryTextListener(object :
        SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            if (query != null) {
                searchMeals(query)
            }
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }
    })

    private fun setupEpoxyController() = binding.apply {
        rvSearchedMeals.setController(mealEpoxyController)
    }

    private fun onMealClick(mealId: Int) {
        val action =
            SearchMealsFragmentDirections.actionSearchMealsFragmentToMealDetailsFragment(mealId = mealId)
        findNavController().navigate(action)
    }

    private fun onFavoriteIconClicked(meal: MealUiModel) {
        TODO()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvSearchedMeals.adapter = null
        mealEpoxyController.setData(emptyList())
        _binding = null
    }
}