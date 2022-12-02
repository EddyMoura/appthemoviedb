package com.example.appthemoviedb.data.framework.remote

import com.example.appthemoviedb.data.framework.network.MovieApi
import com.example.appthemoviedb.data.framework.response.toMovieDetailsModel
import com.example.appthemoviedb.data.framework.response.toMovieModel
import com.example.appthemoviedb.domain.model.MovieDetails
import com.example.appthemoviedb.domain.model.MoviePaging
import com.example.appthemoviedb.domain.repository.MoviesRemoteDataSource
import javax.inject.Inject

class RetrofitMoviesDataSource @Inject constructor(
    private val movieApi: MovieApi
) : MoviesRemoteDataSource {

    override suspend fun fetchNowPlayingMovies(page: Int): MoviePaging {
        val data = movieApi.getNowPlayingMovies(page)
        val movies = data.results.map {
            it.toMovieModel()
        }
        return MoviePaging(
            movies
        )
    }

    override suspend fun fetchComingSoonMovies(page: Int): MoviePaging {
        val data = movieApi.getComingSoonMovies(page)
        val movies = data.results.map {
            it.toMovieModel()
        }
        return MoviePaging(
            movies
        )
    }

    override suspend fun fetchMovieDetails(movieId: Int): MovieDetails {
        return movieApi.getMovieDetails(movieId).toMovieDetailsModel()
    }
}