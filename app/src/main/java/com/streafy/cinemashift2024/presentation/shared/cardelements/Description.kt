package com.streafy.cinemashift2024.presentation.shared.cardelements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

const val RATING_DEFAULT = 4
const val MAX_RATING_DEFAULT = 5

@Composable
fun Description(
    title: String,
    subtitle: String,
    rating: Float,
    buttonText: String,
    onClick: () -> Unit,
    ratingBarValue: Int = RATING_DEFAULT,
    ratingBarMaxValue: Int = MAX_RATING_DEFAULT,
    descriptionText: String = ""
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TitleBlock(title, subtitle)
        RatingsBlock(ratingBarValue, ratingBarMaxValue, rating)
        if (descriptionText.isNotBlank()) {
            Text(
                text = descriptionText,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(size = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9534D2))
        ) {
            Text(
                text = buttonText
            )
        }
    }
}