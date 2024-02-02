package com.streafy.cinemashift2024.data.remote.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleDto(
    val date: String,
    val seances: List<ScheduleSeanceDto>
)
