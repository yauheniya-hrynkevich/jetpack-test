package com.beaverlisk.android.compose.data.api

import com.beaverlisk.android.compose.data.model.BankItem
import com.beaverlisk.android.compose.data.model.Item
import retrofit2.http.GET
import retrofit2.http.Path

interface GW2AccountService {

    @GET("v2/account/bank")
    suspend fun getBankContent(): List<BankItem?>

    @GET("v2/items/{itemId}")
    suspend fun getItem(@Path("itemId") itemId: Long): Item
}