package com.streafy.cinemashift2024.data.remote.model.movie

import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: String,
    val name: String,
    val originalName: String,
    val description: String,
    val releaseDate: String,
    val actors: List<MoviePersonDto>,
    val directors: List<MoviePersonDto>,
    val runtime: Int,
    val ageRating: AgeRating,
    val genres: List<String>,
    val userRatings: UserRatingsDto,
    val img: String,
    val country: CountryDto
)