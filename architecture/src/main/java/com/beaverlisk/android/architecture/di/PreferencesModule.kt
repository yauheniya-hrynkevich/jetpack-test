package com.beaverlisk.android.architecture.di

import android.content.Context
import com.beaverlisk.android.architecture.data.user.UserPreferencesDataStore
import com.beaverlisk.android.architecture.data.user.UserPreferencesStore
import com.beaverlisk.android.architecture.data.user.UserRepository
import com.beaverlisk.android.architecture.data.user.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PreferencesModule {

    @Provides
    fun provideUserPreferencesDataStore(@ApplicationContext context: Context): UserPreferencesStore =
        UserPreferencesDataStore(context)

    @Provides
    fun provideUserRepository(userPreferencesStore: UserPreferencesStore): UserRepository =
        UserRepositoryImpl(userPreferencesStore)

}