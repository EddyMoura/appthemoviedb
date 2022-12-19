package com.example.appthemoviedb.data.framework

import com.example.appthemoviedb.domain.data.repository.favorites.FavoritesLocalDataSource
import com.example.appthemoviedb.domain.data.repository.favorites.FavoritesRepository
import com.example.appthemoviedb.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val favoritesLocalDataSource: FavoritesLocalDataSource
) : FavoritesRepository {
    override fun getAllFavoriteMovies(): Flow<List<Movie>> {
        return favoritesLocalDataSource.getAllFavoriteMovies()
    }

    override suspend fun hasFavorite(movieId: Int): Boolean {
        return favoritesLocalDataSource.hasFavorite(movieId)
    }

    override suspend fun insertFavoriteMovie(movie: Movie) {
        return favoritesLocalDataSource.insertFavoriteMovie(movie)
    }

    override suspend fun deleteFavoriteMovie(movie: Movie) {
        return favoritesLocalDataSource.deleteFavoriteMovie(movie)
    }
}