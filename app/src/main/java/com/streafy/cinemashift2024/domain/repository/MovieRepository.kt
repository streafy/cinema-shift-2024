package com.streafy.cinemashift2024.domain.repository

import com.streafy.cinemashift2024.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMovies(): Flow<List<Movie>>
}