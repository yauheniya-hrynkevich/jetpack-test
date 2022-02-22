package com.beaverlisk.android.architecture.data.user

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface UserRepository {

    suspend fun setApiKey(apiKey: String)

    fun observeApiKey(): Flow<String>
}

class UserRepositoryImpl @Inject constructor(private val userPreferencesStore: UserPreferencesStore) : UserRepository {

    override suspend fun setApiKey(apiKey: String) {
        userPreferencesStore.setApiKey(apiKey)
    }

    //TODO STUB
    override fun observeApiKey(): Flow<String> = userPreferencesStore.getApiKey().map {
        it.ifEmpty { "41AC7619-2F93-C44F-8AE2-575D7BE8D1CC19BFF02D-BD37-4774-B493-8EC201EE3B98" }
    }

}