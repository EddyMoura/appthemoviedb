package com.example.appthemoviedb.data.framework.response

import com.example.appthemoviedb.domain.model.Genre
import com.example.appthemoviedb.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)

fun MovieResponse.toMovieModel(): Movie {
    return Movie(
        posterPath = posterPath,
        title = title,
        id = id,
        backdropPath = backdropPath,
        overview = overview,
        releaseDate = releaseDate,
        voteAverage = voteAverage,
        genres = genreIds,
    )
}


//fun List<Int>.toGenre(genres: List<Genre>): List<Genre> {
//    return this.mapNotNull { genreId ->
//        genres.find {
//            it.id == genreId
//        }
//    }
//}

//fun MovieResponse.toMovieModel(genres: List<Genre>): Movie {
//    return Movie(
//        posterPath = posterPath,
//        title = title,
//        id = id,
//        backdropPath = backdropPath,
//        overview = overview,
//        releaseDate = releaseDate,
//        voteAverage = voteAverage,
//        genres = genreIds.toGenre(genres).map { it.name },
//    )
//}
//
//fun List<Int>.toGenre(genres: List<Genre>): List<Genre> {
//    return this.mapNotNull { genreId ->
//        genres.find {
//            it.id == genreId
//        }
//    }
//}
