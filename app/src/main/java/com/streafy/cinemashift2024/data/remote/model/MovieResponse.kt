package com.streafy.cinemashift2024.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val success: Boolean,
    val reason: String? = null,
    @SerialName("film") val movie: MovieDto
)

