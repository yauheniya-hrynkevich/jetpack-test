package com.beaverlisk.android.architecture.network

import com.beaverlisk.android.architecture.data.user.UserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor(private val userRepository: UserRepository) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = runBlocking {
            userRepository.observeApiKey().first()
        }
        val request = chain.request().newBuilder()
            .addHeader(
                HttpConstant.Header.AUTHORIZATION,
                "${HttpConstant.Header.AUTHORIZATION_TYPE_BEARER} $apiKey"
            )
            .build()
        return chain.proceed(request)
    }
}