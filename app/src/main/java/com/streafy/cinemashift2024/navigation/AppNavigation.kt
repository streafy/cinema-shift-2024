package com.streafy.cinemashift2024.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.streafy.cinemashift2024.navigation.destinations.MOVIE_LIST_ROUTE
import com.streafy.cinemashift2024.navigation.destinations.movieList

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MOVIE_LIST_ROUTE
    ) {
        movieList()
    }
}