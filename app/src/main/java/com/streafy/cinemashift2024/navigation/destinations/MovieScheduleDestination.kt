package com.streafy.cinemashift2024.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.streafy.cinemashift2024.presentation.movieschedule.MovieScheduleScreen
import kotlinx.serialization.Serializable

private const val DEFAULT_TAB = 0

@Serializable
data class MovieSchedule(val id: Int, val selectedTabIndex: Int)

fun NavGraphBuilder.movieSchedule(
    onTabClick: (movieId: Int, tabIndex: Int) -> Unit
) {
    composable<MovieSchedule> { navBackStackEntry ->
        val movieSchedule: MovieSchedule = navBackStackEntry.toRoute()
        val movieId = movieSchedule.id
        val selectedTabIndex = movieSchedule.selectedTabIndex

        MovieScheduleScreen(
            movieId,
            selectedTabIndex,
            onTabClick = { tabIndex -> onTabClick(movieId, tabIndex) }
        )
    }
}

fun NavController.navigateToSchedule(movieId: Int, selectedTab: Int = DEFAULT_TAB) {
    navigate(MovieSchedule(movieId, selectedTab)) {
        popUpTo(MovieDetails(movieId))
    }
}