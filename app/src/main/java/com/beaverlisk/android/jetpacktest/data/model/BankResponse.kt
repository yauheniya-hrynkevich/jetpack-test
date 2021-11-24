package com.beaverlisk.android.jetpacktest.data.model

import com.squareup.moshi.Json

data class BankItem(
    @Json(name = "id") var id: Long = 0,
    @Json(name = "count") var count: Int = 0,
    @Json(name = "binding") var bindingType: String = ""
)
