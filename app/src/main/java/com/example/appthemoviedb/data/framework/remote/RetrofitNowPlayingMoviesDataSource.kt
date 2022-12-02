package com.example.appthemoviedb.data.framework.remote

import com.example.appthemoviedb.data.framework.network.MovieApi
import com.example.appthemoviedb.data.framework.response.toMovieModel
import com.example.appthemoviedb.domain.model.MoviePaging
import com.example.appthemoviedb.domain.repository.NowPlayingMoviesRemoteDataSource
import javax.inject.Inject

class RetrofitNowPlayingMoviesDataSource @Inject constructor(
    private val movieApi: MovieApi
) : NowPlayingMoviesRemoteDataSource {

    override suspend fun fetchNowPlayingMovies(page: Int): MoviePaging {
        val data = movieApi.getNowPlayingMovies(page)
        val movies = data.results.map {
            it.toMovieModel()
        }
        return MoviePaging(
            movies
        )
    }
}