package com.dscjkuat.hiltcode.data.remote

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response

object Authenticator: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder().apply {
            headers(Headers.Builder().apply {
                addAll(originalRequest.headers)
                add(
                    "app-id",
                    "60ca2a3f12bf7749e48462f6"
                )

            }.build())
        }.build()
        return chain.proceed(newRequest)
    }
}