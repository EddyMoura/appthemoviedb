package com.example.appthemoviedb.presenter.moviescomingsoon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.domain.usecase.GetComingSoonMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ComingSoonMoviesViewModel @Inject constructor(
    private val getComingSoonMoviesUseCase: GetComingSoonMoviesUseCase
) : ViewModel() {

    fun comingSoonMoviesPagingData(): Flow<PagingData<Movie>> {
        return getComingSoonMoviesUseCase(
            GetComingSoonMoviesUseCase.GetMoviesParams(getPagingConfig())
        ).cachedIn(viewModelScope)
    }

    private fun getPagingConfig() = PagingConfig(
        pageSize = 20
    )
}