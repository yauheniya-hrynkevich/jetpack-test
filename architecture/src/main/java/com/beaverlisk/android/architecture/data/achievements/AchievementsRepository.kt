package com.beaverlisk.android.architecture.data.achievements

import com.beaverlisk.android.architecture.data.OperationResult
import com.beaverlisk.android.architecture.data.achievements.model.Achievement
import com.beaverlisk.android.architecture.data.achievements.model.AchievementGroupWithCategories
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface AchievementsRepository {

    suspend fun fetchAchievements(ids: List<Int>): OperationResult<List<Achievement>>

    fun observeAchievementGroupsWithCategories(ids: List<Int>): Flow<OperationResult<List<Achievement>>>

    suspend fun fetchAchievementGroupsWithCategories(): OperationResult<List<AchievementGroupWithCategories>>

}

class AchievementsRepositoryImpl @Inject constructor(private val achievementsRemoteDataSource: AchievementsDataSource) :
    AchievementsRepository {

    override suspend fun fetchAchievements(ids: List<Int>): OperationResult<List<Achievement>> =
        achievementsRemoteDataSource.getAchievements(ids)

    override fun observeAchievementGroupsWithCategories(ids: List<Int>): Flow<OperationResult<List<Achievement>>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchAchievementGroupsWithCategories(): OperationResult<List<AchievementGroupWithCategories>> =
        achievementsRemoteDataSource.getAchievementsGroupsWithCategories()

}