package com.example.appthemoviedb.data.framework.di

import com.example.appthemoviedb.data.framework.ComingSoonMoviesRepositoryImpl
import com.example.appthemoviedb.data.framework.NowPlayingMoviesRepositoryImpl
import com.example.appthemoviedb.data.framework.remote.RetrofitComingSoonMoviesDataSource
import com.example.appthemoviedb.data.framework.remote.RetrofitNowPlayingMoviesDataSource
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRemoteDataSource
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRepository
import com.example.appthemoviedb.domain.repository.NowPlayingMoviesRemoteDataSource
import com.example.appthemoviedb.domain.repository.NowPlayingMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindNowPlayingMoviesRepository(repository: NowPlayingMoviesRepositoryImpl): NowPlayingMoviesRepository

    @Binds
    fun bindComingSoonRepository(repository: ComingSoonMoviesRepositoryImpl): ComingSoonMoviesRepository

    @Binds
    fun bindNowPlayingMoviesRemoteDataSource(
        dataSource: RetrofitNowPlayingMoviesDataSource
    ): NowPlayingMoviesRemoteDataSource

    @Binds
    fun bindComingSoonMoviesRemoteDataSource(
        dataSource: RetrofitComingSoonMoviesDataSource
    ): ComingSoonMoviesRemoteDataSource
}