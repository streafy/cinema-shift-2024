package com.streafy.cinemashift2024.data.remote.model.movie

import kotlinx.serialization.Serializable

@Serializable
data class UserRatingsDto(
    val kinopoisk: String,
    val imdb: String
)