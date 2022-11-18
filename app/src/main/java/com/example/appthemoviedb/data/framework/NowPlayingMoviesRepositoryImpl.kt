package com.example.appthemoviedb.data.framework

import androidx.paging.PagingSource
import com.example.appthemoviedb.data.framework.paging.NowPlayingMoviesPagingSource
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.NowPlayingMoviesRemoteDataSource
import com.example.appthemoviedb.domain.repository.NowPlayingMoviesRepository
import javax.inject.Inject

class NowPlayingMoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: NowPlayingMoviesRemoteDataSource<DataContainerResponse>
) : NowPlayingMoviesRepository {

    override fun getNowPlayingMovies(): PagingSource<Int, Movie> {
        return NowPlayingMoviesPagingSource(remoteDataSource)
    }
}