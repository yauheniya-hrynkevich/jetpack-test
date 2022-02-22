package com.beaverlisk.android.architecture.data.achievements.model

data class Achievement(
    val id: Int,
    val name: String,
    val description: String
)

data class AchievementGroup(
    val id: String,
    val name: String,
    val description: String,
    val order: Int,
    val categoriesIds: List<Int>
)

data class AchievementCategory(
    val id: Int,
    val name: String,
    val description: String,
    val order: Int,
    val achievements: List<Achievement>
)

data class AchievementGroupWithCategories(
    val id: String,
    val name: String,
    val description: String,
    val order: Int,
    val categories: List<AchievementCategory>
)