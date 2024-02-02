package com.streafy.cinemashift2024.presentation.movieschedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.streafy.cinemashift2024.domain.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieScheduleViewModel @Inject constructor(
    private val repository: ScheduleRepository
) : ViewModel() {

    private val _state = MutableStateFlow<MovieScheduleUiState>(MovieScheduleUiState.Initial)
    val state = _state.asStateFlow()

    fun getMovieSchedule(movieId: Int, tabId: Int) = viewModelScope.launch {
        _state.value = MovieScheduleUiState.Loading
        try {
            repository.getMovieSchedules(
                movieId = movieId,
                scheduleId = tabId
            ).collect { schedules ->
                _state.value = MovieScheduleUiState.Content(schedules)
            }
        } catch (e: Exception) {
            _state.value = MovieScheduleUiState.Error(e.message)
        }
    }
}