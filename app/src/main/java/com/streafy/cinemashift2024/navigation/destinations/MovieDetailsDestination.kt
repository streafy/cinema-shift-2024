package com.streafy.cinemashift2024.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.streafy.cinemashift2024.presentation.moviedetails.MovieDetailsScreen

private const val BASE_ROUTE = "movie_details"
private const val ID_KEY = "id"

fun NavGraphBuilder.movieDetails() {
    composable(
        route = "$BASE_ROUTE/{$ID_KEY}",
        arguments = listOf(
            navArgument(ID_KEY) {
                type = NavType.IntType
                nullable = false
            }
        )
    ) { navBackStackEntry ->
        val arguments = requireNotNull(navBackStackEntry.arguments)
        val id = arguments.getInt(ID_KEY)

        MovieDetailsScreen(id)
    }
}

fun NavController.navigateToDetails(id: Int) {
    navigate("$BASE_ROUTE/$id")
}