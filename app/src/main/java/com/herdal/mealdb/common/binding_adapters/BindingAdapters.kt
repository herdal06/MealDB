package com.herdal.mealdb.common.binding_adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView, url: String) {
    Glide.with(view).load(url)
        .centerCrop().into(view)
}