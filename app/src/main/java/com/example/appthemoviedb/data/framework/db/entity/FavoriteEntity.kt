package com.example.appthemoviedb.data.framework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appthemoviedb.data.framework.data.DbConstants

@Entity(tableName = DbConstants.FAVORITES_TABLE_NAME)
data class FavoriteEntity(
    @PrimaryKey
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_ID)
    val id: Int,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_TITLE)
    val title: String,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_POSTER_PATH)
    val posterPath: String,
)