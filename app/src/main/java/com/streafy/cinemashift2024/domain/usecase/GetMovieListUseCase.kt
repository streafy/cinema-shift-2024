package com.streafy.cinemashift2024.domain.usecase

import com.streafy.cinemashift2024.domain.repository.MovieRepository

class GetMovieListUseCase(
    private val repository: MovieRepository
) {

    operator fun invoke() =
        repository.getMovies()
}