package com.streafy.cinemashift2024.data.remote

import com.streafy.cinemashift2024.data.remote.model.movie.MovieResponse
import com.streafy.cinemashift2024.data.remote.model.movie.MoviesResponse
import com.streafy.cinemashift2024.data.remote.model.schedule.ScheduleResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET(Endpoints.TODAY_MOVIES)
    suspend fun getMovies(): MoviesResponse

    @GET(Endpoints.MOVIE_BY_ID)
    suspend fun getMovieById(
        @Path("filmId") movieId: String
    ): MovieResponse

    @GET(Endpoints.MOVIE_SCHEDULE)
    suspend fun getMovieSchedule(
        @Path("filmId") movieId: String
    ): ScheduleResponse
}

fun MovieApi(
    baseUrl: String,
    okHttpClient: OkHttpClient? = null,
    json: Json
): MovieApi = retrofit(baseUrl, okHttpClient, json).create()

private fun retrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient?,
    json: Json
): Retrofit {
    val contentType = "application/json".toMediaType()
    val jsonConverterFactory = json.asConverterFactory(contentType)

    val client = okHttpClient ?: OkHttpClient()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .client(client)
        .build()
}

