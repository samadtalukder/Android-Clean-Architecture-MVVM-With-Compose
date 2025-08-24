package com.samad_talukder.mvvmcompose.utils

import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.IOException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response
import java.net.SocketTimeoutException

class ApiStateTest {

    @Test
    fun `safeApiCall returns success when response is successful`() = runBlocking {
        val result = safeApiCall { Response.success("data") }

        assertTrue(result is ApiState.Success)
        assertEquals("data", (result as ApiState.Success).data)
    }

    @Test
    fun `safeApiCall maps 404 to User Not Found`() = runBlocking {
        val errorResponse = Response.error<String>(
            404,
            "Not Found".toResponseBody("text/plain".toMediaType())
        )

        val result = safeApiCall { errorResponse }

        assertTrue(result is ApiState.Error)
        val error = result as ApiState.Error
        assertEquals("User Not Found", error.message)
        assertEquals(404, error.code)
    }

    @Test
    fun `safeApiCall maps 500 to internal server error`() = runBlocking {
        val errorResponse = Response.error<String>(
            500,
            "Server Error".toResponseBody("text/plain".toMediaType())
        )

        val result = safeApiCall { errorResponse }

        assertTrue(result is ApiState.Error)
        val error = result as ApiState.Error
        assertEquals(
            "Internal server error. Please try again later.",
            error.message
        )
        assertEquals(500, error.code)
    }

    @Test
    fun `safeApiCall maps unknown codes to default error`() = runBlocking {
        val errorBody = "Bad Request".toResponseBody("text/plain".toMediaType())
        val rawResponse = okhttp3.Response.Builder()
            .code(400)
            .message("Bad Request")
            .protocol(Protocol.HTTP_1_1)
            .request(Request.Builder().url("http://localhost/").build())
            .build()
        val errorResponse = Response.error<String>(errorBody, rawResponse)

        val result = safeApiCall { errorResponse }

        assertTrue(result is ApiState.Error)
        val error = result as ApiState.Error
        assertEquals("Error: 400 Bad Request", error.message)
        assertEquals(400, error.code)
    }

    @Test
    fun `safeApiCall maps IOException to ApiState Error`() = runBlocking {
        val result = safeApiCall<String> { throw IOException("No Internet") }

        assertTrue(result is ApiState.Error)
        assertEquals("No Internet", (result as ApiState.Error).message)
    }

    @Test
    fun `safeApiCall maps SocketTimeoutException to ApiState Error`() = runBlocking {
        val result = safeApiCall<String> { throw SocketTimeoutException("Timeout") }

        assertTrue(result is ApiState.Error)
        assertEquals("Timeout", (result as ApiState.Error).message)
    }
}

