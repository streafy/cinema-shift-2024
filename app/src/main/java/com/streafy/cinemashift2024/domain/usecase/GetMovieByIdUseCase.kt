package com.streafy.cinemashift2024.domain.usecase

import com.streafy.cinemashift2024.domain.repository.MovieRepository

class GetMovieByIdUseCase(
    private val repository: MovieRepository
) {

    operator fun invoke(movieId: Int) =
        repository.getMovieById(movieId)
}