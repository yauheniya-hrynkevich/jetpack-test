package com.beaverlisk.android.architecture.data.achievements

import com.beaverlisk.android.architecture.data.OperationResult
import com.beaverlisk.android.architecture.data.achievements.model.*
import com.beaverlisk.android.architecture.network.ErrorHandler
import com.beaverlisk.android.architecture.network.api.achievements.AchievementsApi
import kotlinx.coroutines.*
import javax.inject.Inject


class AchievementsRemoteDataSource @Inject constructor(
    private val achievementsApi: AchievementsApi,
    private val errorHandler: ErrorHandler,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : AchievementsDataSource {

    override suspend fun getAchievements(ids: List<Int>): OperationResult<List<Achievement>> {
        return withContext(ioDispatcher) {
            try {
                OperationResult.Success(
                    achievementsApi.getAchievements(ids).map {
                        Achievement(
                            id = it.id,
                            name = it.name,
                            description = it.description
                        )
                    })

            } catch (throwable: Throwable) {
                OperationResult.Error(errorHandler.mapToFailure(throwable))
            }
        }
    }

    override suspend fun getAchievementsGroupsIds(): OperationResult<List<String>> {
        return withContext(ioDispatcher) {
            try {
                OperationResult.Success(achievementsApi.getAchievementsGroupsIds())
            } catch (throwable: Throwable) {
                OperationResult.Error(errorHandler.mapToFailure(throwable))
            }
        }
    }

    //TODO STUB if one call will fail, only failure will return, improve
    override suspend fun getAchievementsGroups(ids: List<String>): OperationResult<List<AchievementGroup>> {
        return withContext(ioDispatcher) {
            try {
                val requests = ids
                    .map { id ->
                        async {
                            val groupResponse = achievementsApi.getAchievementsGroup(id)
                            groupResponse.id to groupResponse
                        }
                    }
                OperationResult.Success(requests.awaitAll()
                    .map {
                        val groupApiModel = it.second
                        AchievementGroup(
                            id = groupApiModel.id,
                            name = groupApiModel.name,
                            description = groupApiModel.description,
                            order = groupApiModel.order,
                            categoriesIds = groupApiModel.categoriesIds
                        )
                    }
                )
            } catch (throwable: Throwable) {
                OperationResult.Error(errorHandler.mapToFailure(throwable))
            }
        }
    }

    override suspend fun getAchievementsCategory(id: Int): OperationResult<AchievementCategory> {
        return withContext(ioDispatcher) {
            try {
                val categoryApiModel = achievementsApi.getAchievementsCategory(id)
                OperationResult.Success(
                    AchievementCategory(
                        id = categoryApiModel.id,
                        name = categoryApiModel.name,
                        description = categoryApiModel.description,
                        order = categoryApiModel.order,
                        achievements = listOf()
                    )
                )
            } catch (throwable: Throwable) {
                OperationResult.Error(errorHandler.mapToFailure(throwable))
            }
        }
    }

    override suspend fun getAchievementsGroupsWithCategories(): OperationResult<List<AchievementGroupWithCategories>> {
        return withContext(ioDispatcher) {
            try {
                val mappedResult = achievementsApi.getAchievementsGroupsIds()
                    .map { groupId ->
                        async {
                            achievementsApi.getAchievementsGroup(groupId)
                        }
                    }
                    .awaitAll()
                    .map { groupApiModel ->
                        val categories = groupApiModel.categoriesIds.map { groupId ->
                            async {
                                achievementsApi.getAchievementsCategory(groupId)
                            }
                        }.awaitAll()
                            .map { categoryApiModel ->
                                AchievementCategory(
                                    id = categoryApiModel.id,
                                    name = categoryApiModel.name,
                                    description = categoryApiModel.description,
                                    order = categoryApiModel.order,
                                    achievements = listOf()
                                )
                            }
                        AchievementGroupWithCategories(
                            id = groupApiModel.id,
                            name = groupApiModel.name,
                            groupApiModel.description,
                            order = groupApiModel.order,
                            categories = categories
                        )
                    }
                OperationResult.Success(mappedResult)
            } catch (throwable: Throwable) {
                OperationResult.Error(errorHandler.mapToFailure(throwable))
            }
        }
    }

    override suspend fun getDailyAchievements(): OperationResult<List<AchievementDaily>> {
        TODO("Not yet implemented")
    }
}