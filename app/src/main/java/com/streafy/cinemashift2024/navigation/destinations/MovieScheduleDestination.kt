package com.streafy.cinemashift2024.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.streafy.cinemashift2024.presentation.movieschedule.MovieScheduleScreen

private const val BASE_ROUTE = "movie_schedule"
private const val ID_KEY = "id"
private const val TAB_KEY = "tab"

private const val DEFAULT_TAB = 0

private const val DETAILS_BASE_ROUTE = "movie_details"

fun NavGraphBuilder.movieSchedule(
    onTabClick: (movieId: Int, tabIndex: Int) -> Unit
) {
    composable(
        route = "$BASE_ROUTE/{$ID_KEY}?tab={$TAB_KEY}",
        arguments = listOf(
            navArgument(ID_KEY) {
                type = NavType.IntType
                nullable = false
            },
            navArgument(TAB_KEY) {
                type = NavType.IntType
                defaultValue = DEFAULT_TAB
            }
        )
    ) { navBackStackEntry ->
        val arguments = requireNotNull(navBackStackEntry.arguments)
        val movieId = arguments.getInt(ID_KEY)
        val selectedTab = arguments.getInt(TAB_KEY)

        MovieScheduleScreen(
            movieId,
            selectedTab,
            onTabClick = { tabIndex -> onTabClick(movieId, tabIndex) }
        )
    }
}

fun NavController.navigateToSchedule(movieId: Int, selectedTab: Int = DEFAULT_TAB) {
    navigate("$BASE_ROUTE/$movieId?tab=$selectedTab") {
        popUpTo("$DETAILS_BASE_ROUTE/$movieId")
    }
}