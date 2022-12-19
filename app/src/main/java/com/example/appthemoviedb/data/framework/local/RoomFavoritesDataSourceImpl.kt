package com.example.appthemoviedb.data.framework.local

import com.example.appthemoviedb.data.framework.db.dao.FavoriteDao
import com.example.appthemoviedb.data.framework.db.entity.toFavoriteEntity
import com.example.appthemoviedb.data.framework.db.entity.toMoviesModel
import com.example.appthemoviedb.domain.data.repository.favorites.FavoritesLocalDataSource
import com.example.appthemoviedb.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomFavoritesDataSourceImpl @Inject constructor(
    private val favoriteDao: FavoriteDao
) : FavoritesLocalDataSource {
    override fun getAllFavoriteMovies(): Flow<List<Movie>> {
        return favoriteDao.getAllFavoriteMovies().map {
            it.toMoviesModel()
        }
    }

    override suspend fun hasFavorite(movieId: Int): Boolean {
        return favoriteDao.hasFavorite(movieId) != null
    }

    override suspend fun insertFavoriteMovie(movie: Movie) {
        return favoriteDao.insertFavoriteMovie(movie.toFavoriteEntity())
    }

    override suspend fun deleteFavoriteMovie(movie: Movie) {
        return favoriteDao.deleteFavoriteMovie(movie.toFavoriteEntity())
    }
}