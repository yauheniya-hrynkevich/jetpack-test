package com.beaverlisk.android.jetpacktest.ui.navigation

import androidx.annotation.StringRes
import com.beaverlisk.android.jetpacktest.R

enum class NavigationScreen(@StringRes val title: Int) {
    SCREEN_BANK(R.string.title_screen_bank),
    SCREEN_ITEM_DETAILS(R.string.title_screen_item_details)
}