package com.example.appthemoviedb.data.framework

import androidx.paging.PagingSource
import com.example.appthemoviedb.data.framework.paging.MoviesPagingSource
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.model.MovieDetails
import com.example.appthemoviedb.domain.repository.MoviesRemoteDataSource
import com.example.appthemoviedb.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {

    override fun getComingSoonMovies(): PagingSource<Int, Movie> {
        return MoviesPagingSource(remoteDataSource)
    }

    override fun getNowPlayingMovies(): PagingSource<Int, Movie> {
        return MoviesPagingSource(remoteDataSource)
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails {
        return remoteDataSource.fetchMovieDetails(movieId)
    }
}