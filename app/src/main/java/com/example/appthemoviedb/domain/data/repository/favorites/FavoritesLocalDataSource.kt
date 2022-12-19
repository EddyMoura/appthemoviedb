package com.example.appthemoviedb.domain.data.repository.favorites

import com.example.appthemoviedb.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface FavoritesLocalDataSource {

    fun getAllFavoriteMovies(): Flow<List<Movie>>
    suspend fun hasFavorite(movieId: Int): Boolean
    suspend fun insertFavoriteMovie(movie: Movie)
    suspend fun deleteFavoriteMovie(movie: Movie)
}