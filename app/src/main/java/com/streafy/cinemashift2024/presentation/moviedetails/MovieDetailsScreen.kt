package com.streafy.cinemashift2024.presentation.moviedetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.streafy.cinemashift2024.R
import com.streafy.cinemashift2024.domain.entity.Movie
import com.streafy.cinemashift2024.presentation.shared.screenstate.Loading

@Composable
fun MovieDetailsScreen(
    movieId: Int,
    onShowScheduleClick: (movieId: Int) -> Unit,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadMovieById(movieId)
    }

    when (val stateValue = state) {
        is MovieDetailsUiState.Content -> Content(
            stateValue.movie,
            onShowScheduleClick
        )
        is MovieDetailsUiState.Error -> Text(text = stringResource(R.string.error))
        MovieDetailsUiState.Initial -> Unit
        MovieDetailsUiState.Loading -> Loading()
    }
}

@Composable
private fun Content(
    movie: Movie,
    onShowScheduleClick: (movieId: Int) -> Unit
) {
    MovieDetailsCard(
        movie = movie,
        onClick = { onShowScheduleClick(movie.id) }
    )
}

