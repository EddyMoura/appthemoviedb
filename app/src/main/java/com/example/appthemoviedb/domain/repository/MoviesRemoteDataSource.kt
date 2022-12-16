package com.example.appthemoviedb.domain.repository

import com.example.appthemoviedb.domain.model.MovieDetails
import com.example.appthemoviedb.domain.model.MoviePaging

interface MoviesRemoteDataSource {

    suspend fun fetchNowPlayingMovies(page: Int): MoviePaging
    suspend fun fetchComingSoonMovies(page: Int): MoviePaging
    suspend fun fetchMovieDetails(movieId: Int): MovieDetails
}