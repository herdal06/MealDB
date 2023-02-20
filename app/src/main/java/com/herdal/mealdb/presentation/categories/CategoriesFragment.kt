package com.herdal.mealdb.presentation.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.databinding.FragmentCategoriesBinding
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.presentation.categories.adapter.CategoryAdapter
import com.herdal.mealdb.utils.ext.collectLatestLifecycleFlow
import com.herdal.mealdb.utils.ext.errorState
import com.herdal.mealdb.utils.ext.loadingState
import com.herdal.mealdb.utils.ext.successState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: CategoriesViewModel by viewModels()

    private val categoryAdapter: CategoryAdapter by lazy {
        CategoryAdapter(::onClickCategory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        val view = binding.root
        collectCategories()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() = binding.apply {
        rvAllCategories.adapter = categoryAdapter
    }

    private fun collectCategories() = binding.apply {
        viewModel.getAllCategories()
        collectLatestLifecycleFlow(viewModel.categories) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    loadingState(tvCategoryError, pbCategories, rvAllCategories)
                }
                is Resource.Success -> {
                    successState(tvCategoryError, pbCategories, rvAllCategories)
                    categoryAdapter.submitList(resource.data)
                }
                is Resource.Error -> {
                    errorState(tvCategoryError, pbCategories, rvAllCategories)
                }
            }
        }
    }

    private fun onClickCategory(category: CategoryUiModel) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvAllCategories.adapter = null
        _binding = null
    }
}