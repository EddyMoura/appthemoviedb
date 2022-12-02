package com.example.appthemoviedb.data.framework.network

import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.data.framework.response.MovieDetailsResponse
import com.example.appthemoviedb.data.framework.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int
    ): DataContainerResponse<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getComingSoonMovies(
        @Query("page") page: Int
    ): DataContainerResponse<MovieResponse>

    @GET("movie/{movieId}")
    suspend fun getMovieDetails(
        @Path("movieId")
        movieId: Int
    ): MovieDetailsResponse

}