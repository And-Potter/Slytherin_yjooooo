package com.yjooooo.sopt28th.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yjooooo.sopt28th.R

object BindingAdapters {
    @BindingAdapter("setSrcFromUrl")
    @JvmStatic
    fun setSrcFromUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .error(R.drawable.img_loading)
            .centerCrop()
            .into(imageView)
    }
}