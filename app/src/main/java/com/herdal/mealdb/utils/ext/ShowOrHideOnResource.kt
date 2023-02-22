package com.herdal.mealdb.utils.ext

import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

fun errorState(tvError: TextView, pb: ProgressBar, rv: RecyclerView? = null) {
    tvError.show()
    pb.gone()
    rv?.gone()
}

fun successState(tvError: TextView, pb: ProgressBar, rv: RecyclerView? = null) {
    tvError.gone()
    pb.gone()
    rv?.show()
}

fun loadingState(tvError: TextView, pb: ProgressBar, rv: RecyclerView? = null) {
    tvError.gone()
    pb.show()
    rv?.hide()
}