package com.beaverlisk.android.jetpacktest.di

import android.content.SharedPreferences
import com.beaverlisk.android.jetpacktest.BuildConfig
import com.beaverlisk.android.jetpacktest.data.api.GW2AccountService
import com.beaverlisk.android.jetpacktest.data.constants.HttpConstant
import com.beaverlisk.android.jetpacktest.data.preferences.PreferencesKeys
import com.beaverlisk.android.jetpacktest.network.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Named(DIContract.NAME_BASE_URL)
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Named(DIContract.NAME_API_KEY)
    fun provideApiKey(sharedPreferences: SharedPreferences): String =
        sharedPreferences.getString(PreferencesKeys.KEY_USER_API_KEY, HttpConstant.Authorization.API_KEY)
            ?: HttpConstant.Authorization.API_KEY

    @Provides
    @Singleton
    fun provideOkHttpClient(@Named(DIContract.NAME_API_KEY) apiKey: String): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(apiKey))
            .also {
                if (BuildConfig.DEBUG)
                    it.addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            }
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @Named(DIContract.NAME_BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideAccountService(retrofit: Retrofit): GW2AccountService =
        retrofit.create(GW2AccountService::class.java)

}