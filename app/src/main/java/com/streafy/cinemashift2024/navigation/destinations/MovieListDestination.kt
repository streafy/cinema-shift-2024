package com.streafy.cinemashift2024.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.streafy.cinemashift2024.presentation.movielist.MovieListScreen

const val MOVIE_LIST_ROUTE = "movie_list"

fun NavGraphBuilder.movieList() {
    composable(route = MOVIE_LIST_ROUTE) {
        MovieListScreen()
    }
}