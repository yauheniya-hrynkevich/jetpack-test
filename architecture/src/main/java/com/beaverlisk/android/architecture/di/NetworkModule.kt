package com.beaverlisk.android.architecture.di

import com.beaverlisk.android.architecture.BuildConfig
import com.beaverlisk.android.architecture.data.user.UserRepository
import com.beaverlisk.android.architecture.network.ApiKeyInterceptor
import com.beaverlisk.android.architecture.network.ErrorHandler
import com.beaverlisk.android.architecture.network.GenericErrorHandlerImpl
import com.beaverlisk.android.architecture.network.api.AchievementsApiImpl
import com.beaverlisk.android.architecture.network.api.achievements.AchievementsApi
import com.beaverlisk.android.architecture.network.api.achievements.AchievementsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiKeyOkHttpInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoggingOkHttpInterceptor

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    @Provides
    fun provideOkHttpClient(
        @ApiKeyOkHttpInterceptor apiKeyInterceptor: Interceptor,
        @LoggingOkHttpInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @ApiKeyOkHttpInterceptor
    fun provideApiKeyInterceptor(userRepository: UserRepository): Interceptor = ApiKeyInterceptor(userRepository)

    @Provides
    @LoggingOkHttpInterceptor
    fun provideLoggingInterceptor(): Interceptor {
        val loggingLevel: HttpLoggingInterceptor.Level =
            if (BuildConfig.BUILD_TYPE == "debug") HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor().setLevel(loggingLevel)
    }

    @Provides
    @Singleton
    fun provideAchievementsApi(achievementsApiService: AchievementsApiService): AchievementsApi =
        AchievementsApiImpl(achievementsApiService)

    @Provides
    @Singleton
    fun provideAchievementsApiService(retrofit: Retrofit): AchievementsApiService =
        retrofit.create(AchievementsApiService::class.java)

    @Provides
    @Singleton
    fun provideApiErrorHandler(): ErrorHandler = GenericErrorHandlerImpl()
}