package com.example.appthemoviedb.data.framework.imageloader

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.appthemoviedb.R
import javax.inject.Inject

class GlideImageLoaderImpl @Inject constructor() : ImageLoader {

    override fun loadImage(
        imageView: ImageView,
        backdropPath: String,
        posterPath: String,
        placeholder: Int,
        fallback: Int
    ) {
        Glide.with(imageView.rootView)
            .load(backdropPath)
            .placeholder(placeholder)
            .fallback(R.drawable.ic_img_loading_error)
            .into(imageView)
    }
}