package com.streafy.cinemashift2024.domain.entity

data class Schedule(
    val date: String,
    val seances: Map<Hall, List<Place>>
)

typealias Hall = String
typealias Place = String