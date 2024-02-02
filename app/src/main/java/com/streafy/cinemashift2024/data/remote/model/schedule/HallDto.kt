package com.streafy.cinemashift2024.data.remote.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class HallDto(
    val name: String,
    val places: List<List<PlaceDto>>
)
