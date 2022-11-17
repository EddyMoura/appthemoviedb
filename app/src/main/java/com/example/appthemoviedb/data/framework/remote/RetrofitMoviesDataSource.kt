package com.example.appthemoviedb.data.framework.remote

import com.example.appthemoviedb.data.framework.network.MovieApi
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.domain.repository.MoviesRemoteDataSource
import javax.inject.Inject

class RetrofitMoviesDataSource @Inject constructor(
    private val movieApi: MovieApi
) : MoviesRemoteDataSource<DataContainerResponse> {

    override suspend fun fetchNowPlayingMovies(page: Int): DataContainerResponse {
        return movieApi.getNowPlayingMovies(page)
    }
}