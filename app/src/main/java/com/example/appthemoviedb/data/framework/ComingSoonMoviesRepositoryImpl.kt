package com.example.appthemoviedb.data.framework

import androidx.paging.PagingSource
import com.example.appthemoviedb.data.framework.paging.ComingSoonMoviesPagingSource
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRemoteDataSource
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRepository
import javax.inject.Inject

class ComingSoonMoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: ComingSoonMoviesRemoteDataSource<DataContainerResponse>
) : ComingSoonMoviesRepository {

    override fun getComingSoonMovies(): PagingSource<Int, Movie> {
        return ComingSoonMoviesPagingSource(remoteDataSource)
    }

}