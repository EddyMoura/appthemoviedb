package com.example.appthemoviedb.domain.model

data class MovieDetails(
    val id: Int,
    val overview: String,
    val backdropPath: String?,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val runtime: Int,
    val genres: List<String>,
) {

    fun getFullBackdropPath() =
        if (backdropPath.isNullOrBlank()) null else BASE_IMAGE_URL + backdropPath

    companion object {
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }
}
