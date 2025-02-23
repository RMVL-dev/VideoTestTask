package com.example.edu.videotesttask.di

import com.example.edu.videotesttask.BuildConfig
import com.example.edu.videotesttask.network.InterceptorCL
import com.example.edu.videotesttask.network.VideoService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideOkHTTP() = OkHttpClient.Builder().apply {
        addInterceptor(InterceptorCL())
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
        addInterceptor(loggingInterceptor)
    }
        .connectTimeout(20000L, TimeUnit.MILLISECONDS)
        .writeTimeout(20000L, TimeUnit.MILLISECONDS)
        .readTimeout(20000L, TimeUnit.MILLISECONDS)
        .build()

    @Provides
    fun provideConverter(): Json = Json { ignoreUnknownKeys = true }

    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient,
        json: Json
    ) = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .client(httpClient)
        .build()

    @Provides
    fun provideService(retrofit: Retrofit): VideoService = retrofit.create(VideoService::class.java)

}