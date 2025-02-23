package com.example.edu.videotesttask.network

import com.example.edu.videotesttask.data.VideoResponse
import retrofit2.Response
import retrofit2.http.GET

interface VideoService {

    /**
     * Тут конечно по уму нужно использовать field переменную, но нас же не интересует
     * реализация поиска разных видео, поэотому оставим хардкодом id фильма
     */
    @GET("films/5047468/videos")
    fun getVideos(): Response<VideoResponse>

}