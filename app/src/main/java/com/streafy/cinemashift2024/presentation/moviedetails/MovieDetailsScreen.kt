package com.streafy.cinemashift2024.presentation.moviedetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.streafy.cinemashift2024.domain.entity.Movie
import com.streafy.cinemashift2024.presentation.shared.screenstate.Loading

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadMovieById(movieId)
    }

    when (val stateValue = state) {
        is MovieDetailsUiState.Content -> Content(stateValue.movie)
        is MovieDetailsUiState.Error -> Text(text = "Error")
        MovieDetailsUiState.Initial -> Unit
        MovieDetailsUiState.Loading -> Loading()
    }
}

@Composable
private fun Content(movie: Movie) {
    MovieDetailsCard(movie = movie)
}

