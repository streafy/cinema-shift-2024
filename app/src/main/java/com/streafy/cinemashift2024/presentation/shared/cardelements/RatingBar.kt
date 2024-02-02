package com.streafy.cinemashift2024.presentation.shared.cardelements

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RatingBar(rating: Int, ratingMax: Int) {
    Row {
        repeat(times = rating) {
            Text(text = "⭐")
        }
        repeat(times = ratingMax - rating) {
            Text(text = "☆")
        }
    }
}