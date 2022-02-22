package com.beaverlisk.android.architecture.network

import androidx.annotation.StringRes
import com.beaverlisk.android.architecture.R
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection

interface Failure {

    @StringRes
    fun getUserMessageRes(): Int

}

sealed class FailureEntity : Failure {

    sealed class ApiFailure : FailureEntity() {

        object AccessDenied : Failure {
            override fun getUserMessageRes(): Int = R.string.error_access_denied
        }

        object Unauthorized : Failure {
            override fun getUserMessageRes(): Int = R.string.error_unauthorized
        }

        object ServiceUnavailable : Failure {
            override fun getUserMessageRes(): Int = R.string.error_service_unavailable
        }

        object Generic : Failure {
            override fun getUserMessageRes(): Int = R.string.error_generic
        }
    }

    object Network : Failure {
        override fun getUserMessageRes(): Int = R.string.error_no_network
    }

    object Unknown : Failure {
        override fun getUserMessageRes(): Int = R.string.error_generic
    }

}

interface ErrorHandler {
    fun mapToFailure(throwable: Throwable): Failure
}

class GenericErrorHandlerImpl : ErrorHandler {

    override fun mapToFailure(throwable: Throwable): Failure {
        return when (throwable) {
            is IOException -> FailureEntity.Network
            is HttpException -> {
                when (throwable.code()) {
                    HttpURLConnection.HTTP_FORBIDDEN -> FailureEntity.ApiFailure.AccessDenied
                    HttpURLConnection.HTTP_UNAVAILABLE -> FailureEntity.ApiFailure.ServiceUnavailable
                    HttpURLConnection.HTTP_UNAUTHORIZED -> FailureEntity.ApiFailure.Unauthorized
                    else -> FailureEntity.ApiFailure.Generic
                }
            }
            else -> FailureEntity.Unknown
        }
    }
}