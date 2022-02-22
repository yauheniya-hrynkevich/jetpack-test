package com.beaverlisk.android.architecture.ui.achievements

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.beaverlisk.android.architecture.R
import com.beaverlisk.android.architecture.data.OperationResult
import com.beaverlisk.android.architecture.databinding.ActivityAchievementsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AchievementsActivity : AppCompatActivity() {

    private val viewModel: AchievementsViewModel by viewModels()
    private lateinit var binding: ActivityAchievementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAchievementsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarWithProgress.toolbar.title = getString(R.string.achievements_title)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.achievementGroupsWithCategories.collect { result ->
                    when (result) {
                        is OperationResult.Loading -> {
                            binding.toolbarWithProgress.progressBar.visibility = View.VISIBLE
                        }
                        is OperationResult.Success -> {
                            binding.toolbarWithProgress.progressBar.visibility = View.GONE
                            Log.e("WUF", "${result.data.map { it.toString() }}")
                        }
                        is OperationResult.Error -> {
                            binding.toolbarWithProgress.progressBar.visibility = View.GONE
                            Toast.makeText(
                                baseContext,
                                result.failure.getUserMessageRes(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }
}