package com.streafy.cinemashift2024.di

import com.streafy.cinemashift2024.data.remote.MovieApi
import com.streafy.cinemashift2024.data.repository.MovieRepositoryImpl
import com.streafy.cinemashift2024.data.repository.ScheduleRepositoryImpl
import com.streafy.cinemashift2024.domain.repository.MovieRepository
import com.streafy.cinemashift2024.domain.repository.ScheduleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository =
        MovieRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideScheduleRepository(api: MovieApi): ScheduleRepository =
        ScheduleRepositoryImpl(api)
}