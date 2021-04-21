package com.dwanz.jetpack_practice.data.util

sealed class ApiResponse<out T: Any> {

    class Success<out T: Any>(val data: T): ApiResponse<T>()

    class Error(val exception: Throwable): ApiResponse<Nothing>()

    fun handleApiResponse(successBlock: (T) -> Unit = {}, failureBlock: (Throwable) -> Unit = {}) {
        when (this) {
            is Success -> successBlock(data)
            is Error -> failureBlock(exception)
        }
    }
}