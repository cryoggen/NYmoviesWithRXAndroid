package com.example.nymovies.presentation.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String) {
    try {
        Glide.with(imageView.context).load(url).into(imageView)
    } catch (e: Exception) {
    }
}