package com.juraj.common.network

sealed class NetworkResult<out T : Any>(val result: T?) {

    data class Success<out T : Any>(val data: T) : NetworkResult<T>(data)

    data class Error<out T : Any>(val error: ErrorResult, val data: T? = null) : NetworkResult<T>(data)
}

open class ErrorResult(open var message: String? = null, open var throwable: Throwable? = null)
