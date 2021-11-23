package com.beaverlisk.android.jetpacktest.data.model

import com.squareup.moshi.Json

data class BankItem(
    @Json(name = "id") val id: Long = 0,
    @Json(name = "count") val count: Int = 0,
    @Json(name = "binding") val bindingType: String = ""
)
