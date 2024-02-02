package com.streafy.cinemashift2024.data.remote.model.movie

import kotlinx.serialization.Serializable

@Serializable
data class MoviePersonDto(
    val id: String,
    val professions: List<MovieProfessions>,
    val fullName: String
)