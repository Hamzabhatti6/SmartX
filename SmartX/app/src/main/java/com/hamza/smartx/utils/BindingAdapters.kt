package com.hamza.smartx.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    @BindingAdapter("load_image")
    @JvmStatic
    fun loadImage(view: ImageView, drawable: Int) {
            Glide.with(view.context)
                .load("")
                .placeholder(drawable)
                .into(view)
    }

}