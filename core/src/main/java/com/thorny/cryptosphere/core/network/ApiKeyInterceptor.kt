package com.thorny.cryptosphere.core.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header(NetworkConstants.API_KEY_HEADER, apiKey)
            .method(original.method, original.body)
            .build()
        return chain.proceed(request)
    }
} 