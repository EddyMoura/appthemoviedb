package com.example.appthemoviedb.domain.repository

import androidx.paging.PagingSource
import com.example.appthemoviedb.domain.model.Movie

interface MoviesRepository {

    fun getNowPlayingMovies(): PagingSource<Int, Movie>
}