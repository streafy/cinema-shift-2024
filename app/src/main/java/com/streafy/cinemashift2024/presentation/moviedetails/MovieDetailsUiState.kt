package com.streafy.cinemashift2024.presentation.moviedetails

import com.streafy.cinemashift2024.domain.entity.Movie

sealed interface MovieDetailsUiState {

    data object Initial : MovieDetailsUiState
    data object Loading : MovieDetailsUiState
    data class Content(val movie: Movie) : MovieDetailsUiState
    data class Error(val message: String?) : MovieDetailsUiState
}