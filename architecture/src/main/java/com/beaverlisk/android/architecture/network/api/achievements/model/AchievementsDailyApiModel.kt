package com.beaverlisk.android.architecture.network.api.achievements.model

import com.squareup.moshi.Json

data class AchievementsDailyApiModel(
    @Json(name = "fractals") val fractals: List<AchievementDailyItemApiModel>,
    @Json(name = "pve") val pve: List<AchievementDailyItemApiModel>,
    @Json(name = "pvp") val pvp: List<AchievementDailyItemApiModel>,
    @Json(name = "special") val special: List<AchievementDailyItemApiModel>,
    @Json(name = "wvw") val wvw: List<AchievementDailyItemApiModel>
)

data class AchievementDailyItemApiModel(
    @Json(name = "id") val id: Int,
    @Json(name = "level") val level: Level,
    @Json(name = "requiredAccess") val requiredAccess: List<String>
)

data class Level(
    @Json(name = "max") val max: Int,
    @Json(name = "min") val min: Int
)
