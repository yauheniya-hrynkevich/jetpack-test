package com.beaverlisk.android.jetpacktest.network

import com.beaverlisk.android.jetpacktest.data.constants.HttpConstant
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(
                HttpConstant.Header.AUTHORIZATION,
                "${HttpConstant.Header.AUTHORIZATION_TYPE_BEARER} $apiKey"
            )
            .build()
        return chain.proceed(request)
    }

}
