package com.streafy.cinemashift2024.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryDto(
    val name: String,
    @SerialName("code") val firstCode: String,
    @SerialName("code2") val secondCode: String,
    val id: Int
)