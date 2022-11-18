package com.example.appthemoviedb.domain.repository

import androidx.paging.PagingSource
import com.example.appthemoviedb.domain.model.Movie

interface NowPlayingMoviesRepository {

    fun getNowPlayingMovies(): PagingSource<Int, Movie>

}