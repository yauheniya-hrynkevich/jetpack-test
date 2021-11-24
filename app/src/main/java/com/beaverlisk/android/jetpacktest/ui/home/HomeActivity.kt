package com.beaverlisk.android.jetpacktest.ui.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beaverlisk.android.jetpacktest.ui.bank.BankContentScreen
import com.beaverlisk.android.jetpacktest.ui.bank.BankViewModel
import com.beaverlisk.android.jetpacktest.ui.navigation.NavigationScreen
import com.beaverlisk.android.jetpacktest.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val bankViewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {
                NavHost(navController, startDestination = NavigationScreen.SCREEN_BANK.name) {
                    composable(NavigationScreen.SCREEN_BANK.name) {
                        BankContentScreen(navController, bankViewModel)
                    }
                    composable(NavigationScreen.SCREEN_ITEM_DETAILS.name) {
                        BankContentScreen(navController, bankViewModel)
                    }
                }
            }
        }
    }
}