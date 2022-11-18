package com.example.appthemoviedb.data.framework.remote

import com.example.appthemoviedb.data.framework.network.MovieApi
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.domain.repository.NowPlayingMoviesRemoteDataSource
import javax.inject.Inject

class RetrofitNowPlayingMoviesDataSource @Inject constructor(
    private val movieApi: MovieApi
) : NowPlayingMoviesRemoteDataSource<DataContainerResponse> {

    override suspend fun fetchNowPlayingMovies(page: Int): DataContainerResponse {
        return movieApi.getNowPlayingMovies(page)
    }
}