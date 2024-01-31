package com.streafy.cinemashift2024.data.remote

import com.streafy.cinemashift2024.data.remote.model.MoviesResponse
import retrofit2.http.GET

interface MovieApi {

    @GET(Endpoints.TODAY_MOVIES)
    suspend fun getMovies(): MoviesResponse
}