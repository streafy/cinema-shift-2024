package com.streafy.cinemashift2024.data.repository

import com.streafy.cinemashift2024.data.mappers.toSchedule
import com.streafy.cinemashift2024.data.remote.MovieApi
import com.streafy.cinemashift2024.domain.entity.Schedule
import com.streafy.cinemashift2024.domain.repository.MovieDates
import com.streafy.cinemashift2024.domain.repository.ScheduleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ScheduleRepositoryImpl(
    private val movieApi: MovieApi
) : ScheduleRepository {

    override fun getMovieSchedules(
        movieId: Int,
        scheduleId: Int
    ): Flow<Pair<MovieDates, Schedule>> = flow {
        val schedules = movieApi
            .getMovieSchedule(movieId.toString())
            .schedules

        val movieDates = schedules.map { it.date }
        val schedule = schedules[scheduleId].toSchedule()

        emit(Pair(movieDates, schedule))
    }
}