package com.beaverlisk.android.architecture.ui.achievements

import androidx.lifecycle.ViewModel
import com.beaverlisk.android.architecture.data.OperationResult
import com.beaverlisk.android.architecture.data.achievements.AchievementsRepository
import com.beaverlisk.android.architecture.data.achievements.model.AchievementGroupWithCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class AchievementsViewModel @Inject constructor(private val achievementsRepository: AchievementsRepository) : ViewModel() {

    val achievementGroupsWithCategories: Flow<OperationResult<List<AchievementGroupWithCategories>>> = flow {
        emit(OperationResult.Loading)
        emit(achievementsRepository.fetchAchievementGroupsWithCategories())
    }

}