package com.example.appthemoviedb.data.framework.di

import com.example.appthemoviedb.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetComingSoonMoviesUseCase(useCaseImpl: GetComingSoonMoviesUseCaseImpl): GetComingSoonMoviesUseCase

    @Binds
    fun bindGetNowPlayingMoviesUseCase(useCaseImpl: GetNowPlayingMoviesUseCaseImpl): GetNowPlayingMoviesUseCase

    @Binds
    fun bindGetMovieDetails(useCaseImpl: GetMovieDetailsUseCaseImp): GetMovieDetailsUseCase
}