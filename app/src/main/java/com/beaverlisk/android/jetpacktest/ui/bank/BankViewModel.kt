package com.beaverlisk.android.jetpacktest.ui.bank

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beaverlisk.android.jetpacktest.data.model.Item
import com.beaverlisk.android.jetpacktest.data.repository.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BankViewModel @Inject constructor(private val repository: AccountRepository) : ViewModel() {

    var bankContentStateList = mutableStateListOf<Item>()

    init {
        getBankContent()
    }

    private fun getBankContent() {
        viewModelScope.launch {
            repository.getBankContent().collect {
                bankContentStateList.addAll(it)
            }
        }
    }
}