package com.streafy.cinemashift2024.di

import com.streafy.cinemashift2024.data.remote.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import javax.inject.Singleton

const val BASE_URL = "https://shift-backend.onrender.com"

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideMovieApi(okHttpClient: OkHttpClient, json: Json): MovieApi =
        MovieApi(BASE_URL, okHttpClient, json)

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideJson() = Json { ignoreUnknownKeys = true }
}