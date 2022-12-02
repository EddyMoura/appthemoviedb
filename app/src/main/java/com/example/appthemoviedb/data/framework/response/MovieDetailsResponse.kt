package com.example.appthemoviedb.data.framework.response

import com.example.appthemoviedb.domain.model.MovieDetails
import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("revenue")
    val revenue: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
)

fun MovieDetailsResponse.toMovieDetailsModel(): MovieDetails {
    return MovieDetails(
        id = this.id,
        overview = this.overview,
        backdropPath
    )
}