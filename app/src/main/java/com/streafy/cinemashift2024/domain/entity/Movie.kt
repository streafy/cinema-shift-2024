package com.streafy.cinemashift2024.domain.entity

data class Movie(
    val id: Int,
    val name: String,
    val originalName: String,
    val description: String,
    val genres: List<String>,
    val country: String,
    val userRating: Float,
    val releaseYear: Int?,
    val img: String
)