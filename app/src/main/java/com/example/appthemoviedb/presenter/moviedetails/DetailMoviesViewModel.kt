package com.example.appthemoviedb.presenter.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appthemoviedb.domain.model.MovieDetails
import com.example.appthemoviedb.domain.usecase.GetMovieDetailsUseCase
import com.example.appthemoviedb.domain.usecase.base.ResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
data class DetailMoviesViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun getMovieDetails(movieId: Int) = viewModelScope.launch {
        getMovieDetailsUseCase(GetMovieDetailsUseCase.GetMovieDetailsParams(movieId)).watchStatus()
    }

    private fun Flow<ResultStatus<MovieDetails>>.watchStatus() = viewModelScope.launch {
        collect { status ->
            _uiState.value = when (status) {
                ResultStatus.Loading -> UiState.Loading
                is ResultStatus.Success -> UiState.Success(status.data)
                is ResultStatus.Error -> UiState.Error
            }
        }
    }

    sealed class UiState {
        object Loading : UiState()
        data class Success(val movieDetails: MovieDetails) : UiState()
        object Error : UiState()
    }
}
