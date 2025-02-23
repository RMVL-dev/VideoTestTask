package com.example.edu.videotesttask.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VideoItem(
    @SerialName("url")
    val url: String,
    @SerialName("name")
    val name: String,
    @SerialName("site")
    val site: String
)

