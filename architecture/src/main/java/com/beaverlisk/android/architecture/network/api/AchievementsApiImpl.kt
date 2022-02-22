package com.beaverlisk.android.architecture.network.api

import com.beaverlisk.android.architecture.network.api.achievements.AchievementsApi
import com.beaverlisk.android.architecture.network.api.achievements.AchievementsApiService
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsCategoryApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsDailyApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsGroupApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsItemApiModel

class AchievementsApiImpl(private val achievementsApiService: AchievementsApiService) : AchievementsApi {

    override suspend fun getAchievementsGroup(id: String): AchievementsGroupApiModel {
        return achievementsApiService.fetchAchievementsGroup(id)
    }

    override suspend fun getAchievementsGroupsIds(): List<String> {
        return achievementsApiService.fetchAchievementsGroupsIds()
    }

    override suspend fun getAchievementsCategory(id: Int): AchievementsCategoryApiModel {
        return achievementsApiService.fetchAchievementsCategory(id)
    }

    override suspend fun getAchievementsCategoriesIds(): List<Int> {
        return achievementsApiService.fetchAchievementsCategoriesIds()
    }

    override suspend fun getAchievements(ids: List<Int>): List<AchievementsItemApiModel> {
        val query = ids.joinToString(",")
        return achievementsApiService.fetchAchievements(query)
    }

    override suspend fun getDailyAchievements(): List<AchievementsDailyApiModel> {
        return achievementsApiService.fetchDailyAchievements()
    }
}