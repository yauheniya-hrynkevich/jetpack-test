package com.beaverlisk.android.jetpacktest.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.beaverlisk.android.jetpacktest.R

sealed class MainNavigationRoute(val route: String, @DrawableRes val icon: Int, @StringRes val title: Int) {
    object Home : MainNavigationRoute("home", R.drawable.ic_home, R.string.title_screen_home)
    object Bank : MainNavigationRoute("bank", R.drawable.ic_bank, R.string.title_screen_bank)
}