package com.example.appthemoviedb.domain.repository

interface MoviesRemoteDataSource<T> {

    suspend fun fetchNowPlayingMovies(page: Int): T
}