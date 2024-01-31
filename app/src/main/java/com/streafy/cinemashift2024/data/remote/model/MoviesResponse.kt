package com.streafy.cinemashift2024.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    val success: Boolean,
    val reason: String? = null,
    @SerialName("films") val movies: List<MovieDto>
)
