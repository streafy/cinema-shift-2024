package com.streafy.cinemashift2024.data.repository

import com.streafy.cinemashift2024.data.mappers.toMovie
import com.streafy.cinemashift2024.data.remote.MovieApi
import com.streafy.cinemashift2024.domain.entity.Movie
import com.streafy.cinemashift2024.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val api: MovieApi
) : MovieRepository {

    override fun getMovies(): Flow<List<Movie>> = flow {
        val movies = api.getMovies().movies
        emit(movies.map { movieDto -> movieDto.toMovie() })
    }
}