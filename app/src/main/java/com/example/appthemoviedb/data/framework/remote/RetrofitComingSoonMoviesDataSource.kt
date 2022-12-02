package com.example.appthemoviedb.data.framework.remote

import com.example.appthemoviedb.data.framework.network.MovieApi
import com.example.appthemoviedb.data.framework.response.toMovieModel
import com.example.appthemoviedb.domain.model.MoviePaging
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRemoteDataSource
import javax.inject.Inject

class RetrofitComingSoonMoviesDataSource @Inject constructor(
    private val movieApi: MovieApi
) : ComingSoonMoviesRemoteDataSource {

    override suspend fun fetchComingSoonMovies(page: Int): MoviePaging {
        val data = movieApi.getComingSoonMovies(page)
        val movies = data.results.map {
            it.toMovieModel()
        }
        return MoviePaging(
            movies
        )
    }
}