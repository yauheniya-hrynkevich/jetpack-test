package com.beaverlisk.android.architecture.data.user

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface UserPreferencesStore {

    fun getApiKey(): Flow<String>

    suspend fun setApiKey(apiKey: String)

}

val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences_data_store")

class UserPreferencesDataStore @Inject constructor(@ApplicationContext context: Context) : UserPreferencesStore {

    private val dataStore = context.userPreferencesDataStore

    override fun getApiKey(): Flow<String> = dataStore.data.map {
        it[UserPreferencesKeys.API_KEY] ?: ""
    }

    override suspend fun setApiKey(apiKey: String) {
        dataStore.edit { prefs ->
            prefs[UserPreferencesKeys.API_KEY] = apiKey
        }
    }

}