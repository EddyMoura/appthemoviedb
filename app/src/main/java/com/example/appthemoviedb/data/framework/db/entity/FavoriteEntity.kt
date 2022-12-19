package com.example.appthemoviedb.data.framework.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appthemoviedb.data.framework.db.DbConstants
import com.example.appthemoviedb.domain.model.Movie

@Entity(tableName = DbConstants.FAVORITES_TABLE_NAME)
data class FavoriteEntity(
    @PrimaryKey
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_ID)
    val id: Int,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_TITLE)
    val title: String,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_POSTER_PATH)
    val posterPath: String?,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_BACKDROP_PATH)
    val backdropPath: String?,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_OVERVIEW)
    val overview: String?,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_RELEASE_DATE)
    val releaseDate: String?,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_VOTE_AVERAGE)
    val voteAverage: Double,
    @ColumnInfo(name = DbConstants.FAVORITES_COLUMN_INFO_GENRES)
    val genres: List<Int>,
)

fun List<FavoriteEntity>.toMoviesModel() = map {
    Movie(
        posterPath = it.posterPath,
        backdropPath = it.backdropPath,
        overview = it.overview,
        releaseDate = it.releaseDate,
        id = it.id,
        title = it.title,
        voteAverage = it.voteAverage,
        genres = it.genres
    )
}

fun Movie.toFavoriteEntity(): FavoriteEntity {
   return FavoriteEntity(
        posterPath = posterPath,
        backdropPath = backdropPath,
        overview = overview,
        releaseDate = releaseDate,
        id = id,
        title = title,
        voteAverage = voteAverage,
        genres = genres
    )
}