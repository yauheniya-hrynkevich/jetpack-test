package com.beaverlisk.android.compose.di

import com.beaverlisk.android.compose.data.api.GW2AccountService
import com.beaverlisk.android.compose.data.repository.AccountRepository
import com.beaverlisk.android.compose.data.repository.AccountRepositoryImpl
import com.beaverlisk.android.compose.data.repository.LocalAccountDataSource
import com.beaverlisk.android.compose.data.repository.RemoteAccountDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class AccountModule {

    @Provides
    fun provideRemoteDataSource(accountService: GW2AccountService): RemoteAccountDataSource =
        RemoteAccountDataSource(accountService)

    @Provides
    fun provideLocalDataSource(): LocalAccountDataSource = LocalAccountDataSource()

    @Provides
    fun provideAccountRepository(
        localDataSource: LocalAccountDataSource,
        remoteDataSource: RemoteAccountDataSource
    ): AccountRepository = AccountRepositoryImpl(localDataSource, remoteDataSource)

}