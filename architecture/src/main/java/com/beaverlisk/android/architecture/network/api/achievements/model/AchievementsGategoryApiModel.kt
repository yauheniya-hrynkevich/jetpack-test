package com.beaverlisk.android.architecture.network.api.achievements.model

import com.squareup.moshi.Json

data class AchievementsCategoryApiModel(
    @Json(name = "id") val id: Int,
    @Json(name = "description") val description: String,
    @Json(name = "name") val name: String,
    @Json(name = "achievements") val achievementsIds: List<Int>,
    @Json(name = "icon") val icon: String,
    @Json(name = "order") val order: Int
)