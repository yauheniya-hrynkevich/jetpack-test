package com.beaverlisk.android.architecture.di

import com.beaverlisk.android.architecture.data.achievements.AchievementsDataSource
import com.beaverlisk.android.architecture.data.achievements.AchievementsRemoteDataSource
import com.beaverlisk.android.architecture.data.achievements.AchievementsRepository
import com.beaverlisk.android.architecture.data.achievements.AchievementsRepositoryImpl
import com.beaverlisk.android.architecture.network.ErrorHandler
import com.beaverlisk.android.architecture.network.api.achievements.AchievementsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class AchievementsModule {

    @Provides
    @ViewModelScoped
    fun provideAchievementRepository(achievementsRemoteDataSource: AchievementsDataSource): AchievementsRepository =
        AchievementsRepositoryImpl(achievementsRemoteDataSource)

    @Provides
    fun provideAchievementsRemoteDataSource(
        achievementsApi: AchievementsApi,
        errorHandler: ErrorHandler
    ): AchievementsDataSource =
        AchievementsRemoteDataSource(achievementsApi, errorHandler)
}