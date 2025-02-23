package com.example.edu.videotesttask.domain

import com.example.edu.videotesttask.data.VideoResponse
import com.example.edu.videotesttask.network.VideoService
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api:VideoService
):Repository {
    override suspend fun getVideos(): Response<VideoResponse> =
        api.getVideos()
}