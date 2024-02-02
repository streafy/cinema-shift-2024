package com.streafy.cinemashift2024.data.remote.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleResponse(
    val success: Boolean,
    val reason: String? = null,
    val schedules: List<ScheduleDto>
)
