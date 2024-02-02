package com.streafy.cinemashift2024.data.remote.model.schedule

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TicketDto(
    @SerialName("filmId") val movieId: String,
    val row: Int,
    val column: Int,
    val seance: SeanceDto,
    val phone: String
)
