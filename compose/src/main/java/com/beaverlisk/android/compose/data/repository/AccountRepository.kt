package com.beaverlisk.android.compose.data.repository

import com.beaverlisk.android.compose.data.api.GW2AccountService
import com.beaverlisk.android.compose.data.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject


interface AccountDataSource {

    fun getBankContent(): Flow<List<Item>>
}

class LocalAccountDataSource : AccountDataSource {

    override fun getBankContent(): Flow<List<Item>> = flow { listOf(Item()) }

}

class RemoteAccountDataSource @Inject constructor(private val accountService: GW2AccountService) : AccountDataSource {

    override fun getBankContent(): Flow<List<Item>> = flow {
        val bankItems: List<Item> = accountService.getBankContent()
            .mapNotNull { bankItem ->
                bankItem?.let { accountService.getItem(it.id) }
            }
        emit(bankItems)
    }.flowOn(Dispatchers.IO)

}

interface AccountRepository {

    fun getBankContent(): Flow<List<Item>>
}

class AccountRepositoryImpl @Inject constructor(
    private val localAccountDataSource: LocalAccountDataSource,
    private val remoteAccountDataSource: RemoteAccountDataSource
) : AccountRepository {

    override fun getBankContent(): Flow<List<Item>> = remoteAccountDataSource.getBankContent()
}
