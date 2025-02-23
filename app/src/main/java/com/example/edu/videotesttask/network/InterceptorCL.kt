package com.example.edu.videotesttask.network

import com.example.edu.videotesttask.BuildConfig
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.net.SocketTimeoutException

class InterceptorCL: Interceptor {

    companion object{
        private const val API_KEY = "X-API-KEY"
        private const val CONTENT_TYPE_VALUE = "application/json"
        private const val CONTENT_TYPE = "Content-Type"

    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val origin = chain.request()
        val builder = origin.newBuilder()

        val request = builder
            .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
            .header(API_KEY, BuildConfig.API_KEY)
            .method(origin.method, origin.body)
            .build()

        return runCatching {
            chain.proceed(request = request)
        }.getOrElse { error ->
            return@getOrElse when (error) {
                is SocketTimeoutException ->
                    Response.Builder()
                        .protocol(Protocol.HTTP_1_1)
                        .request(request)
                        .code(499)
                        .body("{${error}}".toResponseBody(null))
                        .build()

                else ->
                    Response.Builder()
                        .request(request)
                        .protocol(Protocol.HTTP_1_1)
                        .code(499)
                        .body("{${error}}".toResponseBody(null))
                        .build()
            }
        }
    }

}