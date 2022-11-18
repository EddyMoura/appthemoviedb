package com.example.appthemoviedb.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.repository.ComingSoonMoviesRepository
import com.example.appthemoviedb.domain.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetComingSoonMoviesUseCase @Inject constructor(
    private val moviesRepository: ComingSoonMoviesRepository
) : PagingUseCase<GetComingSoonMoviesUseCase.GetMoviesParams, Movie>() {

    override fun createFlowObservable(params: GetMoviesParams): Flow<PagingData<Movie>> {
        return Pager(
            config = params.pagingConfig
        ) {
            moviesRepository.getComingSoonMovies()
        }.flow
    }

    data class GetMoviesParams(val pagingConfig: PagingConfig)
}