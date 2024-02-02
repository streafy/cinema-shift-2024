package com.streafy.cinemashift2024.data.remote.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class SeanceDto(
    val date: String,
    val time: String
)
