package com.streafy.cinemashift2024.presentation.shared.cardelements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.streafy.cinemashift2024.R

@Composable
fun RatingBar(rating: Int, ratingMax: Int) {
    Row {
        repeat(times = rating) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.star_solid_full),
                contentDescription = null
            )
        }
        repeat(times = ratingMax - rating) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.star_solid),
                contentDescription = null
            )
        }
    }
}