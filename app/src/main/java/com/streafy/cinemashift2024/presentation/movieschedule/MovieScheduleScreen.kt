package com.streafy.cinemashift2024.presentation.movieschedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.streafy.cinemashift2024.domain.entity.Schedule
import com.streafy.cinemashift2024.presentation.shared.screenstate.ErrorScreen
import com.streafy.cinemashift2024.presentation.shared.screenstate.Loading

@Composable
fun MovieScheduleScreen(
    movieId: Int,
    selectedTab: Int,
    onTabClick: (tabIndex: Int) -> Unit,
    viewModel: MovieScheduleViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getMovieSchedule(movieId, selectedTab)
    }

    when (val stateValue = state) {
        is MovieScheduleUiState.Content -> {
            val (movieDates, schedule) = stateValue.movieDatesWithSchedule
            Content(
                schedule,
                movieDates,
                selectedTab,
                onTabClick = onTabClick
            )
        }
        is MovieScheduleUiState.Error -> ErrorScreen(
            errorMessage = stateValue.message,
            onRetry = { viewModel.getMovieSchedule(movieId, selectedTab)
        })
        MovieScheduleUiState.Initial -> Unit
        MovieScheduleUiState.Loading -> Loading()
    }
}

@Composable
private fun Content(
    schedule: Schedule,
    dates: List<String>,
    selectedTab: Int,
    onTabClick: (tabIndex: Int) -> Unit
) {
    Column {
        ScrollableTabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier,
            edgePadding = 16.dp
        ) {
            dates.forEachIndexed { index, date ->
                Tab(selected = index == selectedTab, onClick = { onTabClick(index) }) {
                    Text(text = date, modifier = Modifier.padding(vertical = 16.dp))
                }
            }

        }
        Seances(schedule.seances)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun Seances(seancesGrouped: Map<String, List<String>>) {
    seancesGrouped.entries.forEach { (hall, seances) ->
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(text = hall)
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                seances.forEach {
                    Button(onClick = { }) {
                        Text(text = it)
                    }
                }
            }
        }
    }


}