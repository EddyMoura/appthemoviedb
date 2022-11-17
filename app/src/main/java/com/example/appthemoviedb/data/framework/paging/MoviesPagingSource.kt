package com.example.appthemoviedb.data.framework.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.data.framework.response.toMovie
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.MoviesRemoteDataSource

class MoviesPagingSource(
    private val remoteDataSource: MoviesRemoteDataSource<DataContainerResponse>
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageIndex = params.key ?: MOVIE_PAGE_INDEX
            val response = remoteDataSource.fetchNowPlayingMovies(pageIndex)
            val movies = response.results.map { it.toMovie() }

            LoadResult.Page(
                data = movies,
                prevKey = if (pageIndex == MOVIE_PAGE_INDEX) null else pageIndex - 1,
                nextKey = if (movies.isEmpty()) null else pageIndex + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(MOVIE_PAGE_INDEX)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(MOVIE_PAGE_INDEX)
        }
    }

    companion object {
        private const val MOVIE_PAGE_INDEX = 1
    }
}