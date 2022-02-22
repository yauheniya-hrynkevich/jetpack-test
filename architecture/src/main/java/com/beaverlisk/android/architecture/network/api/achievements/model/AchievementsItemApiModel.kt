package com.beaverlisk.android.architecture.network.api.achievements.model

import com.squareup.moshi.Json

data class AchievementsItemApiModel(
    @Json(name = "bits") val bits: List<BitApiModel>,
    @Json(name = "description") val description: String,
    @Json(name = "flags") val flags: List<String>,
    @Json(name = "id") val id: Int,
    @Json(name = "lockedText") val lockedText: String,
    @Json(name = "name") val name: String,
    @Json(name = "requirement") val requirement: String,
    @Json(name = "rewards") val rewards: List<RewardApiModel>,
    @Json(name = "tiers") val tiers: List<TierApiModel>,
    @Json(name = "type") val type: String
)

data class BitApiModel(
    @Json(name = "id") val id: Int,
    @Json(name = "type") val type: String
)

data class RewardApiModel(
    @Json(name = "count") val count: Int,
    @Json(name = "id") val id: Int,
    @Json(name = "type") val type: String
)

data class TierApiModel(
    @Json(name = "count") val count: Int,
    @Json(name = "points") val points: Int
)
