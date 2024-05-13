package com.streafy.cinemashift2024.domain.usecase

import com.streafy.cinemashift2024.domain.entity.Movie
import com.streafy.cinemashift2024.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieListUseCase(repository: MovieRepository) : () -> Flow<List<Movie>> by repository::getMovies


//) {
//
//    operator fun invoke() =
//        repository.getMovies()
//}