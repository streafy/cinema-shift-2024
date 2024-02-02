package com.streafy.cinemashift2024.presentation.moviedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.streafy.cinemashift2024.domain.entity.Movie

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

@Composable
private fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}