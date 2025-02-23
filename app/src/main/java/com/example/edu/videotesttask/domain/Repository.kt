package com.example.edu.videotesttask.domain

import com.example.edu.videotesttask.data.VideoResponse
import retrofit2.Response

interface Repository {
    suspend fun getVideos():Response<VideoResponse>
}