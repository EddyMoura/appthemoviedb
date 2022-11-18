package com.example.appthemoviedb.data.framework.network

import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page: Int
    ): DataContainerResponse

}