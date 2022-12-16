package com.example.appthemoviedb.data.framework.imageloader

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.example.appthemoviedb.R

interface ImageLoader {

    fun loadImage(
        imageView: ImageView,
        backdropPath: String,
        posterPath: String,
        @DrawableRes placeholder: Int = R.drawable.ic_img_placeholder,
        @DrawableRes fallback: Int = R.drawable.ic_img_loading_error
    )
}