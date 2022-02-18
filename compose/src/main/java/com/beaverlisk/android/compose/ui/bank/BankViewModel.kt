package com.beaverlisk.android.compose.ui.bank

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beaverlisk.android.compose.data.model.Item
import com.beaverlisk.android.compose.data.repository.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
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
            repository.getBankContent()
                .catch {
                    // exception ->
                    //handleError(exception.message)
                }
                .collect { bankItems ->
                    bankContentStateList.addAll(bankItems)
                }
        }
    }
}