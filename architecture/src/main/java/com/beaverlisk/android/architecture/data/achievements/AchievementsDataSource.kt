package com.beaverlisk.android.architecture.data.achievements

import com.beaverlisk.android.architecture.data.OperationResult
import com.beaverlisk.android.architecture.data.achievements.model.*

interface AchievementsDataSource {

    suspend fun getAchievements(ids: List<Int>): OperationResult<List<Achievement>>

    suspend fun getAchievementsGroupsIds():  OperationResult<List<String>>

    suspend fun getAchievementsGroups(ids: List<String>):  OperationResult<List<AchievementGroup>>

    suspend fun getAchievementsCategory(id: Int):  OperationResult<AchievementCategory>

    suspend fun getAchievementsGroupsWithCategories(): OperationResult<List<AchievementGroupWithCategories>>

    suspend fun getDailyAchievements():  OperationResult<List<AchievementDaily>>

}