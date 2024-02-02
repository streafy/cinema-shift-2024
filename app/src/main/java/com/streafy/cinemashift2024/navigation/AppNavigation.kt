package com.streafy.cinemashift2024.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.streafy.cinemashift2024.navigation.destinations.MOVIE_LIST_ROUTE
import com.streafy.cinemashift2024.navigation.destinations.movieDetails
import com.streafy.cinemashift2024.navigation.destinations.movieList
import com.streafy.cinemashift2024.navigation.destinations.navigateToDetails

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MOVIE_LIST_ROUTE
    ) {
        movieList(
            onMovieClick = { movie ->
                navController.navigateToDetails(movie.id)
            }
        )
        movieDetails()
    }
}