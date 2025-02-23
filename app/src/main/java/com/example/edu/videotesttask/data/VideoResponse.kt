package com.example.edu.videotesttask.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoResponse(
    @SerialName("total")
    val total: Int,
    @SerialName("items")
    val items: List<VideoItem>
)
