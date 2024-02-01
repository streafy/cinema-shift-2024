package com.streafy.cinemashift2024.presentation.movielist

import com.streafy.cinemashift2024.domain.entity.Movie

sealed interface MovieListUiState {

    data object Initial : MovieListUiState
    data object Loading : MovieListUiState
    data class Content(val movies: List<Movie>) : MovieListUiState
    data class Error(val message: String?) : MovieListUiState
}
