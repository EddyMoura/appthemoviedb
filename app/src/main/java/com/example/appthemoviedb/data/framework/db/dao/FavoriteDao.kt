package com.example.appthemoviedb.data.framework.db.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appthemoviedb.data.framework.db.DbConstants
import com.example.appthemoviedb.data.framework.db.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM ${DbConstants.FAVORITES_TABLE_NAME}")
    fun getAllFavoriteMovies(): Flow<List<FavoriteEntity>>

    @Query("SELECT * FROM ${DbConstants.FAVORITES_TABLE_NAME} WHERE id = :movieId")
    suspend fun hasFavorite(movieId: Int): FavoriteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteMovie(favoriteEntity: FavoriteEntity)

    @Delete
    suspend fun deleteFavoriteMovie(favoriteEntity: FavoriteEntity)
}