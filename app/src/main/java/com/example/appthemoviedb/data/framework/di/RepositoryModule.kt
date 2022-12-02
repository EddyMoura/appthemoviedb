package com.example.appthemoviedb.data.framework.di

import com.example.appthemoviedb.data.framework.MoviesRepositoryImpl
import com.example.appthemoviedb.data.framework.remote.RetrofitMoviesDataSource
import com.example.appthemoviedb.domain.repository.MoviesRemoteDataSource
import com.example.appthemoviedb.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindMoviesRepository(repository: MoviesRepositoryImpl): MoviesRepository

    @Binds
    fun bindMovieRemoteDataSource(
        dataSource: RetrofitMoviesDataSource
    ): MoviesRemoteDataSource

}