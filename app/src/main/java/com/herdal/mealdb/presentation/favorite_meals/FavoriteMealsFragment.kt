package com.herdal.mealdb.presentation.favorite_meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.herdal.mealdb.databinding.FragmentFavoriteMealsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMealsFragment : Fragment() {

    private var _binding: FragmentFavoriteMealsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteMealsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}