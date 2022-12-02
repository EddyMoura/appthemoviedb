package com.example.appthemoviedb.domain.repository

import com.example.appthemoviedb.domain.model.MoviePaging

interface NowPlayingMoviesRemoteDataSource {

    suspend fun fetchNowPlayingMovies(page: Int): MoviePaging

}