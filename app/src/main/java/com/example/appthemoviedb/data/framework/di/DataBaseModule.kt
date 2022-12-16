package com.example.appthemoviedb.data.framework.di

import android.content.Context
import androidx.room.Room
import com.example.appthemoviedb.data.framework.data.DbConstants
import com.example.appthemoviedb.data.framework.db.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    fun provideFavoriteDatabase(
        @ApplicationContext context: Context
    ): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        DbConstants.APP_DATABASE_NAME
    ).build()

    @Provides
    fun provideFavoriteDao(appDataBase: AppDataBase) = appDataBase.favoriteDao()

}