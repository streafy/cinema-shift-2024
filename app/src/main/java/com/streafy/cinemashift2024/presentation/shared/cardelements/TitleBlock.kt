package com.streafy.cinemashift2024.presentation.shared.cardelements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TitleBlock(title: String, subtitle: String) {
    Column {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Text(text = subtitle, style = MaterialTheme.typography.bodyMedium)
    }
}