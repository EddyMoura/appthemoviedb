package com.example.appthemoviedb.data.framework

import androidx.paging.PagingSource
import com.example.appthemoviedb.data.framework.paging.MoviesPagingSource
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.MoviesRemoteDataSource
import com.example.appthemoviedb.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource<DataContainerResponse>
) : MoviesRepository {

    override fun getNowPlayingMovies(): PagingSource<Int, Movie> {
        return MoviesPagingSource(remoteDataSource)
    }
}