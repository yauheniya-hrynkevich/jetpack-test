package com.beaverlisk.android.architecture.network.api.achievements.model

import com.squareup.moshi.Json

data class AchievementsGroupApiModel(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "order") val order: Int,
    @Json(name = "categories") val categoriesIds: List<Int>,
    @Json(name = "description") val description: String,
)