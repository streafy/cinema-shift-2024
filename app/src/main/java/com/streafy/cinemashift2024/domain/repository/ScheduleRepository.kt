package com.streafy.cinemashift2024.domain.repository

import com.streafy.cinemashift2024.domain.entity.Schedule
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {

    fun getMovieSchedule(
        movieId: Int,
        scheduleId: Int
    ): Flow<Pair<MovieDates, Schedule>>
}

typealias MovieDates = List<String>