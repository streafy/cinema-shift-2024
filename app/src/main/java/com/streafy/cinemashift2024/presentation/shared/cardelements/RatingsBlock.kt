package com.streafy.cinemashift2024.presentation.shared.cardelements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RatingsBlock(
    ratingBarValue: Int,
    ratingBarMaxValue: Int,
    rating: Float
) {
    Column {
        RatingBar(rating = ratingBarValue, ratingMax = ratingBarMaxValue)
        Text(text = "Kinopoisk - $rating")
    }
}