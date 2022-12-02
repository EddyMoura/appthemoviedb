package com.example.appthemoviedb.domain.repository

import com.example.appthemoviedb.domain.model.MoviePaging

interface ComingSoonMoviesRemoteDataSource {

    suspend fun fetchComingSoonMovies(page: Int): MoviePaging
}