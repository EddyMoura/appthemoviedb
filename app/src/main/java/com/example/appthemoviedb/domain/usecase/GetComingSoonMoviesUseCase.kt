package com.example.appthemoviedb.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.MoviesRepository
import com.example.appthemoviedb.domain.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetComingSoonMoviesUseCase {
    operator fun invoke(params: GetMoviesParams): Flow<PagingData<Movie>>

    data class GetMoviesParams(val pagingConfig: PagingConfig)
}

class GetComingSoonMoviesUseCaseImpl @Inject constructor(
    private val moviesRepository: MoviesRepository
) : PagingUseCase<GetComingSoonMoviesUseCase.GetMoviesParams, Movie>(), GetComingSoonMoviesUseCase {

    override fun createFlowObservable(params: GetComingSoonMoviesUseCase.GetMoviesParams): Flow<PagingData<Movie>> {
        return Pager(
            config = params.pagingConfig
        ) {
            moviesRepository.getComingSoonMovies()
        }.flow
    }
}