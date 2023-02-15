package com.herdal.mealdb.presentation.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.herdal.mealdb.common.Resource
import com.herdal.mealdb.databinding.FragmentCategoriesBinding
import com.herdal.mealdb.domain.uimodel.CategoryUiModel
import com.herdal.mealdb.presentation.categories.adapter.CategoryAdapter
import com.herdal.mealdb.utils.ext.hide
import com.herdal.mealdb.utils.ext.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

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
        lifecycleScope.launchWhenStarted {
            viewModel.getAllCategories()
            viewModel.categories.collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        tvCategoryError.hide()
                        rvAllCategories.hide()
                    }
                    is Resource.Success -> {
                        tvCategoryError.hide()
                        pbCategories.hide()
                        rvAllCategories.show()
                        categoryAdapter.submitList(resource.data)
                    }
                    is Resource.Error -> {
                        tvCategoryError.show()
                        pbCategories.hide()
                        rvAllCategories.hide()
                    }
                }
            }
        }
    }

    private fun onClickCategory(category: CategoryUiModel) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}