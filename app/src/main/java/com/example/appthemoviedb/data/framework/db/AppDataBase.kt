package com.example.appthemoviedb.data.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.appthemoviedb.data.framework.db.dao.FavoriteDao
import com.example.appthemoviedb.data.framework.db.entity.FavoriteEntity

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao
}