package com.streafy.cinemashift2024.di

import com.streafy.cinemashift2024.domain.repository.MovieRepository
import com.streafy.cinemashift2024.domain.repository.ScheduleRepository
import com.streafy.cinemashift2024.domain.usecase.GetMovieByIdUseCase
import com.streafy.cinemashift2024.domain.usecase.GetMovieListUseCase
import com.streafy.cinemashift2024.domain.usecase.GetMovieScheduleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideGetMovieListUseCase(movieRepository: MovieRepository) =
        GetMovieListUseCase(movieRepository)

    @Provides
    fun provideGetMovieByIdUseCase(movieRepository: MovieRepository) =
        GetMovieByIdUseCase(movieRepository)

    @Provides
    fun provideGetMovieScheduleUseCase(scheduleRepository: ScheduleRepository) =
        GetMovieScheduleUseCase(scheduleRepository)
}