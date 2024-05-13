package com.streafy.cinemashift2024.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.streafy.cinemashift2024.domain.entity.Movie
import com.streafy.cinemashift2024.presentation.movielist.MovieListScreen
import kotlinx.serialization.Serializable

@Serializable
object MovieList

fun NavGraphBuilder.movieList(
    onMovieClick: (Movie) -> Unit
) {
    composable<MovieList> {
        MovieListScreen(onMovieClick = onMovieClick)
    }
}