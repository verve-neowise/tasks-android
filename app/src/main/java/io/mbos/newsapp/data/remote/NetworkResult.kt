package io.mbos.newsapp.data.remote

sealed class NetworkResult<T> {
    class Success<T>(val response: T): NetworkResult<T>()
    class Error<T>(val message: String): NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()
}