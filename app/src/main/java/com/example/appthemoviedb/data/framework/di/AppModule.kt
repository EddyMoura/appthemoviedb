package com.example.appthemoviedb.data.framework.di

import com.example.appthemoviedb.data.framework.imageloader.GlideImageLoaderImpl
import com.example.appthemoviedb.data.framework.imageloader.ImageLoader
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface AppModule {

    @Binds
    fun bindImageLoader(imageLoader: GlideImageLoaderImpl): ImageLoader
}