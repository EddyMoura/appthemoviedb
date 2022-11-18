package com.example.appthemoviedb.domain.model

data class Movie(
    val posterPath: String?,
    val backdropPath: String?,
    val overview: String?,
    val releaseDate: String?,
    val id: Int,
    val title: String,
    val voteAverage: Double,
    val genres: List<Int>,
) {

    fun getFullPosterPath() =
        if (posterPath.isNullOrBlank()) null else BASE_IMAGE_URL + posterPath

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }
}

