package com.beaverlisk.android.architecture.data.achievements.model

data class AchievementDaily(
    val type: SourceType,
    val name: String,
    val description: String
)

enum class SourceType {
    PVE, PVP, FRACTAL, WVW, SPECIAL
}

