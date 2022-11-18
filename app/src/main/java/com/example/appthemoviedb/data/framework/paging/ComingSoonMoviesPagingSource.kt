package com.example.appthemoviedb.data.framework.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.appthemoviedb.data.framework.response.DataContainerResponse
import com.example.appthemoviedb.data.framework.response.toMovie
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRemoteDataSource
import retrofit2.HttpException
import java.io.IOException

class ComingSoonMoviesPagingSource(
    private val remoteDataSource: ComingSoonMoviesRemoteDataSource<DataContainerResponse>
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageIndex = params.key ?: MOVIE_STARTING_PAGE_INDEX
            val response = remoteDataSource.fetchComingSoonMovies(pageIndex)
            val movies = response.results.map { it.toMovie() }

            LoadResult.Page(
                data = movies,
                prevKey = if (pageIndex == MOVIE_STARTING_PAGE_INDEX) null else pageIndex - 1,
                nextKey = if (movies.isEmpty()) null else pageIndex + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val MOVIE_STARTING_PAGE_INDEX = 1
    }
}