package com.beaverlisk.android.jetpacktest.di

import com.beaverlisk.android.jetpacktest.data.api.GW2AccountService
import com.beaverlisk.android.jetpacktest.data.repository.AccountRepository
import com.beaverlisk.android.jetpacktest.data.repository.AccountRepositoryImpl
import com.beaverlisk.android.jetpacktest.data.repository.LocalAccountDataSource
import com.beaverlisk.android.jetpacktest.data.repository.RemoteAccountDataSource
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