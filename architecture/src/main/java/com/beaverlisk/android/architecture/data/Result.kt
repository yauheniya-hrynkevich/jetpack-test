package com.beaverlisk.android.architecture.data

import com.beaverlisk.android.architecture.network.Failure

sealed class OperationResult<out T> {
    class Success<out T>(val data: T) : OperationResult<T>()
    class Error(val failure: Failure) : OperationResult<Nothing>()
    object Loading : OperationResult<Nothing>()
}



