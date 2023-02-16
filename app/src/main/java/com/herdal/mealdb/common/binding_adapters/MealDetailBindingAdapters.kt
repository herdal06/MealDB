package com.herdal.mealdb.common.binding_adapters

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import com.herdal.mealdb.R

@BindingAdapter("expandOrCollapse")
fun expandOrCollapse(imageButton: ImageButton, linearLayout: LinearLayout) {
    val parentViewGroup = linearLayout.parent as? ViewGroup ?: return
    imageButton.setOnClickListener {
        if (linearLayout.visibility == View.GONE) {
            TransitionManager.beginDelayedTransition(parentViewGroup, AutoTransition())
            linearLayout.visibility = View.VISIBLE
            imageButton.setImageResource(R.drawable.ic_expand_less)
        } else {
            TransitionManager.beginDelayedTransition(parentViewGroup, AutoTransition())
            linearLayout.visibility = View.GONE
            imageButton.setImageResource(R.drawable.ic_expand_more)
        }
    }
}