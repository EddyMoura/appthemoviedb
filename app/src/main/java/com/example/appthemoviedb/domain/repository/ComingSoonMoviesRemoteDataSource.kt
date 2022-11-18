package com.example.appthemoviedb.domain.repository

interface ComingSoonMoviesRemoteDataSource<T> {

    suspend fun fetchComingSoonMovies(page: Int): T
}