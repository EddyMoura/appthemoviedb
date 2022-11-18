package com.example.appthemoviedb.data.framework.remote

import com.example.appthemoviedb.data.framework.network.MovieApi
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRemoteDataSource
import javax.inject.Inject

class RetrofitComingSoonMoviesDataSource @Inject constructor(
    private val movieApi: MovieApi
) : ComingSoonMoviesRemoteDataSource<DataContainerResponse> {

    override suspend fun fetchComingSoonMovies(page: Int): DataContainerResponse {
        return movieApi.getComingSoonMovies(page)
    }
}