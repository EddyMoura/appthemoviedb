package com.example.appthemoviedb.domain.repository

import androidx.paging.PagingSource
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.model.MovieDetails

interface MoviesRepository {

    fun getComingSoonMovies(): PagingSource<Int, Movie>
    fun getNowPlayingMovies(): PagingSource<Int, Movie>
    suspend fun getMovieDetails(movieId: Int): MovieDetails
}