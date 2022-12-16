package com.example.appthemoviedb.domain.usecase

import com.example.appthemoviedb.domain.model.MovieDetails
import com.example.appthemoviedb.domain.repository.MoviesRepository
import com.example.appthemoviedb.domain.usecase.base.ResultStatus
import com.example.appthemoviedb.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetMovieDetailsUseCase {

    operator fun invoke(params: GetMovieDetailsParams): Flow<ResultStatus<MovieDetails>>

    data class GetMovieDetailsParams(val movieId: Int)
}

class GetMovieDetailsUseCaseImp @Inject constructor(
    private val moviesRepository: MoviesRepository
) : GetMovieDetailsUseCase, UseCase<GetMovieDetailsUseCase.GetMovieDetailsParams, MovieDetails>() {

    override suspend fun doWork(
        params: GetMovieDetailsUseCase.GetMovieDetailsParams
    ): ResultStatus<MovieDetails> {
        val movies = moviesRepository.getMovieDetails(params.movieId)
        return ResultStatus.Success(movies)
    }
}