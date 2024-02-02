package com.streafy.cinemashift2024.domain.usecase

import com.streafy.cinemashift2024.domain.repository.ScheduleRepository

class GetMovieScheduleUseCase(
    private val repository: ScheduleRepository
) {

    operator fun invoke(movieId: Int, scheduleId: Int) =
        repository.getMovieSchedules(movieId, scheduleId)
}