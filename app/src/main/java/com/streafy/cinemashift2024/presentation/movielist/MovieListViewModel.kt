package com.streafy.cinemashift2024.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.cinemashift2024.domain.usecase.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<MovieListUiState>(MovieListUiState.Initial)
    val state = _state.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() = viewModelScope.launch {
        _state.value = MovieListUiState.Loading
        try {
            getMovieListUseCase().collect { movies ->
                _state.value = MovieListUiState.Content(movies)
            }
        } catch (e: Exception) {
            _state.value = MovieListUiState.Error(e.message)
        }
    }
}