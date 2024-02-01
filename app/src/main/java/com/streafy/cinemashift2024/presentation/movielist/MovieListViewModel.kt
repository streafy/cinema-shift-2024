package com.streafy.cinemashift2024.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.cinemashift2024.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _state = MutableStateFlow<MovieListUiState>(MovieListUiState.Initial)
    val state = _state.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() = viewModelScope.launch {
        _state.value = MovieListUiState.Loading
        repository.getMovies().collect { movies ->
            _state.value = MovieListUiState.Content(movies)
        }
    }
}