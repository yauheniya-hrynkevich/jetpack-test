package com.beaverlisk.android.jetpacktest.ui.bank

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import com.beaverlisk.android.jetpacktest.ui.base.ActivityLifeCycleObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BankFragment : Fragment(), DefaultLifecycleObserver {

    private val viewModel by viewModels<BankViewModel>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().lifecycle.addObserver(ActivityLifeCycleObserver { activityCreated() })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(context = requireContext()).apply {
            setContent {
                BankScreen(viewModel.bankContentStateList)
            }
        }
    }

    private fun activityCreated() {
        // lifecycle aware callback, no op for now
    }

    companion object {
        fun newInstance() = BankFragment()
    }


}