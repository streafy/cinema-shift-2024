package com.streafy.cinemashift2024.data.remote.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleSeanceDto(
    val time: String,
    val hall: HallDto,
    val payedTickets: List<TicketDto>
)
