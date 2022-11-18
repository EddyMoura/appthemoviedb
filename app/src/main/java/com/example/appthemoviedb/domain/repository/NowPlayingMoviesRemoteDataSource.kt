package com.example.appthemoviedb.domain.repository

interface NowPlayingMoviesRemoteDataSource<T> {

    suspend fun fetchNowPlayingMovies(page: Int): T

}