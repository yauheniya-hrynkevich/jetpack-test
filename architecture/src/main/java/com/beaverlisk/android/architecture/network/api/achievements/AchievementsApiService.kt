package com.beaverlisk.android.architecture.network.api.achievements

import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsCategoryApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsDailyApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsGroupApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsItemApiModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AchievementsApiService {

    @GET("/v2/achievements")
    suspend fun fetchAchievementsIds(): List<Int>

    @GET("/v2/achievements/groups")
    suspend fun fetchAchievementsGroupsIds(): List<String>

    @GET("/v2/achievements/categories")
    suspend fun fetchAchievementsCategoriesIds(): List<Int>

    @GET("/v2/account/achievements")
    suspend fun fetchAccountAchievements(): List<Int>

    @GET("/v2/achievements")
    suspend fun fetchAchievements(@Query("ids") idsSeparatedWithComma: String): List<AchievementsItemApiModel>

    @GET("/v2/achievements/groups/{id}")
    suspend fun fetchAchievementsGroup(@Path("id") id: String): AchievementsGroupApiModel

    @GET("/v2/achievements/categories/{id}")
    suspend fun fetchAchievementsCategory(@Path("id") id: Int): AchievementsCategoryApiModel

    @GET("/v2/achievements/daily")
    suspend fun fetchDailyAchievements(): List<AchievementsDailyApiModel>

}