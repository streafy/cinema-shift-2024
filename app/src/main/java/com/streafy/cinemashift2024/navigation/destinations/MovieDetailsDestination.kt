package com.streafy.cinemashift2024.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.streafy.cinemashift2024.presentation.moviedetails.MovieDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetails(val id: Int)

fun NavGraphBuilder.movieDetails(
    onShowScheduleClick: (movieId: Int) -> Unit
) {
    composable<MovieDetails> { navBackStackEntry ->
        val movieDetails: MovieDetails = navBackStackEntry.toRoute()
        val id = movieDetails.id

        MovieDetailsScreen(id, onShowScheduleClick)
    }
}

fun NavController.navigateToDetails(id: Int) {
    navigate(MovieDetails(id))
}