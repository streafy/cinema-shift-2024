package com.streafy.cinemashift2024.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.streafy.cinemashift2024.navigation.destinations.MovieList
import com.streafy.cinemashift2024.navigation.destinations.movieDetails
import com.streafy.cinemashift2024.navigation.destinations.movieList
import com.streafy.cinemashift2024.navigation.destinations.movieSchedule
import com.streafy.cinemashift2024.navigation.destinations.navigateToDetails
import com.streafy.cinemashift2024.navigation.destinations.navigateToSchedule

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MovieList
    ) {
        movieList(
            onMovieClick = { movie ->
                navController.navigateToDetails(movie.id)
            }
        )
        movieDetails(
            onShowScheduleClick = { movieId ->
                navController.navigateToSchedule(movieId)
            }
        )
        movieSchedule(
            onTabClick = { movieId, tabIndex ->
                navController.navigateToSchedule(movieId, tabIndex)
            }
        )
    }
}