package com.streafy.cinemashift2024.presentation.movielist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.streafy.cinemashift2024.domain.entity.Movie

const val BASE_URL = "https://shift-backend.onrender.com" //TODO: extract somewhere

@Composable
fun MovieCard(movie: Movie) {
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
            onDetailsClick = {}
        )
    }
}

@Composable
private fun ImageWithLabel(
    movieImageUri: String,
    genre: String,
    country: String,
    releaseYear: String
) {
    Box {
        AsyncImage(
            model = "$BASE_URL${movieImageUri}",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(
                    color = Color(0xFFF5F5F8),
                    shape = RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 0.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = genre, style = MaterialTheme.typography.labelLarge)
            Text(text = "$country $releaseYear")
        }
    }
}

@Composable
private fun Description(
    title: String,
    subtitle: String,
    ratingBarValue: Int,
    ratingBarMaxValue: Int,
    rating: Float,
    onDetailsClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TitleBlock(title, subtitle)
        RatingsBlock(ratingBarValue, ratingBarMaxValue, rating)
        Button(
            onClick = onDetailsClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(size = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9534D2))
        ) {
            Text(
                text = "Подробнее"
            )
        }
    }
}

@Composable
private fun TitleBlock(title: String, subtitle: String) {
    Column {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Text(text = subtitle, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun RatingsBlock(
    ratingBarValue: Int,
    ratingBarMaxValue: Int,
    rating: Float
) {
    Column {
        RatingBar(rating = ratingBarValue, ratingMax = ratingBarMaxValue)
        Text(text = "Kinopoisk - $rating")
    }
}

@Composable
private fun RatingBar(rating: Int, ratingMax: Int) {
    Row {
        repeat(times = rating) {
            Text(text = "⭐")
        }
        repeat(times = ratingMax - rating) {
            Text(text = "☆")
        }
    }
}