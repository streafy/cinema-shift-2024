package com.streafy.cinemashift2024.presentation.movieschedule

import com.streafy.cinemashift2024.domain.entity.Schedule
import com.streafy.cinemashift2024.domain.repository.MovieDates

sealed interface MovieScheduleUiState {

    data object Initial : MovieScheduleUiState
    data object Loading : MovieScheduleUiState
    data class Content(val movieDatesWithSchedule: Pair<MovieDates, Schedule>) : MovieScheduleUiState
    data class Error(val message: String?) : MovieScheduleUiState
}