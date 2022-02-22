package com.beaverlisk.android.architecture.network.api.achievements

import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsCategoryApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsDailyApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsGroupApiModel
import com.beaverlisk.android.architecture.network.api.achievements.model.AchievementsItemApiModel

interface AchievementsApi {

    suspend fun getAchievementsGroupsIds(): List<String>

    suspend fun getAchievementsGroup(id: String): AchievementsGroupApiModel

    suspend fun getAchievementsCategoriesIds(): List<Int>

    suspend fun getAchievementsCategory(id: Int): AchievementsCategoryApiModel

    suspend fun getAchievements(ids: List<Int>): List<AchievementsItemApiModel>

    suspend fun getDailyAchievements(): List<AchievementsDailyApiModel>

}