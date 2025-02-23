package com.example.edu.videotesttask.network

sealed interface ResponseState<T> {
    data class Success<T>(val data:T):ResponseState<T>
    class Error<T>(val message:String):ResponseState<T>
    class Loading<T>():ResponseState<T>
    class None<T>():ResponseState<T>
}