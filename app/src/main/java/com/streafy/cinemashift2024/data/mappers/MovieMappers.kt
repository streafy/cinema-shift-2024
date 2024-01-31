package com.streafy.cinemashift2024.data.mappers

import com.streafy.cinemashift2024.data.remote.model.MovieDto
import com.streafy.cinemashift2024.domain.entity.Movie
import java.time.LocalDate
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.Locale

fun MovieDto.toMovie() = Movie(
    id = id.toInt(),
    name = name,
    description = description,
    genres = genres,
    country = country.name,
    userRating = userRatings.kinopoisk.toFloat(),
    releaseYear = releaseDate.parseYear(),
)

private fun String.parseYear(): Int? {
    val formatter = DateTimeFormatterBuilder()
        .appendPattern("[d MMMM yyyy]")
        .appendPattern("[yyyy]")
        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
        .toFormatter(Locale("ru"))
    return try {
        LocalDate.parse(this, formatter).year
    } catch (e: Exception) {
        null
    }
}