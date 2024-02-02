package com.streafy.cinemashift2024.data.mappers

import com.streafy.cinemashift2024.data.remote.model.schedule.ScheduleDto
import com.streafy.cinemashift2024.data.remote.model.schedule.ScheduleSeanceDto
import com.streafy.cinemashift2024.domain.entity.Hall
import com.streafy.cinemashift2024.domain.entity.Place
import com.streafy.cinemashift2024.domain.entity.Schedule

fun ScheduleDto.toSchedule() = Schedule(
    date = date,
    seances = seances.toDomain()
)

private fun List<ScheduleSeanceDto>.toDomain(): Map<Hall, List<Place>> =
    this.map { seance -> seance.hall.name to seance.time }
        .groupBy { (hallName, _) -> hallName }
        .map { (hall, hallToSeanceList) ->
            Pair(hall, hallToSeanceList.map { (_, seances) -> seances })
        }
        .toMap()
