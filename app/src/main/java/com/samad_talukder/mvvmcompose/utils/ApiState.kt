/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.utils

import okio.IOException
import retrofit2.Response
import java.net.SocketTimeoutException

sealed class ApiState<out T> {
    data class Success<out T>(val data: T) : ApiState<T>()
    data class Error(val message: String, val code: Int? = null) : ApiState<Nothing>()
}

suspend fun <T> safeApiCall(
    apiResponse: suspend () -> Response<T>
): ApiState<T> = try {
    val response = apiResponse()

    if (response.isSuccessful) {
        val body = response.body()

        body?.let {
            ApiState.Success(it)
        } ?: apiError("Empty response body")

    } else {
        val errorCode = response.code()
        val errorMessage = when (errorCode) {
            404 -> "User Not Found"
            500 -> "Internal server error. Please try again later."
            502 -> "Bad gateway. Please try again later."
            503 -> "Service unavailable. Please try again later."
            504 -> "Gateway timeout. Please try again later."
            else -> "Error: ${response.code()} ${response.message()}"
        }

        ApiState.Error(errorMessage, errorCode)
    }

} catch (ex: Exception) {
    apiError(ex.message ?: ex.toString())
} catch (io: IOException) {
    apiError(io.message ?: "No Internet")
} catch (sc: SocketTimeoutException) {
    apiError(sc.message ?: "Timeout")
}

fun <T> apiError(errorMessage: String): ApiState<T> = ApiState.Error(errorMessage)
