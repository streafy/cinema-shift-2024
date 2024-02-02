package com.streafy.cinemashift2024.presentation.movielist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.streafy.cinemashift2024.R
import com.streafy.cinemashift2024.domain.entity.Movie
import com.streafy.cinemashift2024.presentation.shared.cardelements.Description
import com.streafy.cinemashift2024.presentation.shared.cardelements.ImageWithLabel

@Composable
fun MovieCard(
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        ImageWithLabel(
            movieImageUri = movie.img,
            genre = movie.genres.firstOrNull() ?: "",
            country = movie.country,
            releaseYear = movie.releaseYear?.toString() ?: ""
        )
        Description(
            title = movie.name,
            subtitle = movie.originalName,
            ratingBarValue = 4,
            ratingBarMaxValue = 5,
            rating = movie.userRating,
            buttonText = stringResource(R.string.details),
            onClick = { onMovieClick(movie) }
        )
    }
}