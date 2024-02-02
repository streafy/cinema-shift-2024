package com.streafy.cinemashift2024.data.remote

import com.streafy.cinemashift2024.data.remote.model.MovieResponse
import com.streafy.cinemashift2024.data.remote.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET(Endpoints.TODAY_MOVIES)
    suspend fun getMovies(): MoviesResponse

    @GET(Endpoints.MOVIE_BY_ID)
    suspend fun getMovieById(
        @Path("filmId") movieId: String
    ): MovieResponse

}