package com.example.appthemoviedb.data.framework.di

import com.example.appthemoviedb.data.framework.FavoritesRepositoryImpl
import com.example.appthemoviedb.data.framework.local.RoomFavoritesDataSourceImpl
import com.example.appthemoviedb.domain.data.repository.favorites.FavoritesLocalDataSource
import com.example.appthemoviedb.domain.data.repository.favorites.FavoritesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface FavoritesRepositoryModule {

    @Binds
    fun bindFavoritesRepository(
        favoritesRepository: FavoritesRepositoryImpl
    ): FavoritesRepository

    @Binds
    fun bindFavoriteLocalDataSource(
        dataSource: RoomFavoritesDataSourceImpl
    ): FavoritesLocalDataSource

}