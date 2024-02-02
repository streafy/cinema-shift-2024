package com.streafy.cinemashift2024.data.remote.model.schedule

import kotlinx.serialization.Serializable

@Serializable
data class PlaceDto(
    val price: Int,
    val type: PlaceType
)
