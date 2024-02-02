package com.streafy.cinemashift2024.presentation.moviedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.cinemashift2024.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _state = MutableStateFlow<MovieDetailsUiState>(MovieDetailsUiState.Initial)
    val state = _state.asStateFlow()

    fun loadMovieById(id: Int) = viewModelScope.launch {
        _state.value = MovieDetailsUiState.Loading
        try {
            repository.getMovieById(id).collect { movie ->
                _state.value = MovieDetailsUiState.Content(movie)
            }
        } catch (e: Exception) {
            _state.value = MovieDetailsUiState.Error(e.message)
        }
    }
}