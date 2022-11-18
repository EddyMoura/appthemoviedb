package com.example.appthemoviedb.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.NowPlayingMoviesRepository
import com.example.appthemoviedb.domain.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val moviesRepository: NowPlayingMoviesRepository
) : PagingUseCase<GetNowPlayingMoviesUseCase.GetMoviesParams, Movie>() {

    override fun createFlowObservable(params: GetMoviesParams): Flow<PagingData<Movie>> {
        return Pager(
            config = params.pagingConfig
        ) {
            moviesRepository.getNowPlayingMovies()
        }.flow
    }

    data class GetMoviesParams(val pagingConfig: PagingConfig)
}