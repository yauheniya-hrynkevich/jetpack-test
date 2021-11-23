package com.beaverlisk.android.jetpacktest.ui.bank

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import com.beaverlisk.android.jetpacktest.R
import com.beaverlisk.android.jetpacktest.data.model.Item
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

    @Composable
    fun BankScreen(bankItems: List<Item>) {
        Scaffold(
            content = {
                BankItemsList(bankItems)
            }
        )
    }

    @Composable
    fun BankItemsList(bankItems: List<Item>) {
        LazyColumn {
            itemsIndexed(items = bankItems) { index, item ->
                BankItemListItem(item = item)
            }
        }
    }


    @Preview
    @Composable
    fun BankItemListItem(item: Item = Item.createMockObject()) {
        Row {
            Column {
                Text(text = item.name, style = typography.subtitle1)
                Text(text = item.description, style = typography.body1)
                Text(text = item.rarity, style = typography.body2)
            }
        }
    }

    companion object {
        fun newInstance() = BankFragment()
    }


}