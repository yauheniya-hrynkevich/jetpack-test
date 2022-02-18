package com.beaverlisk.android.compose.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beaverlisk.android.compose.ui.bank.BankContentScreen
import com.beaverlisk.android.compose.ui.bank.BankViewModel
import com.beaverlisk.android.compose.ui.common.NavigationToolbar
import com.beaverlisk.android.compose.ui.navigation.BottomNavigationBar
import com.beaverlisk.android.compose.ui.navigation.MainNavigationRoute
import com.beaverlisk.android.compose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    private val bankViewModel: BankViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme {
                Scaffold(
                    topBar = { NavigationToolbar("") {} },
                    bottomBar = { BottomNavigationBar() }
                ) {
                    NavHost(navController, startDestination = MainNavigationRoute.Bank.route) {
                        composable(MainNavigationRoute.Bank.route) {
                            BankContentScreen(navController, bankViewModel)
                        }
                        composable(MainNavigationRoute.Bank.route) {
                            BankContentScreen(navController, bankViewModel)
                        }
                    }
                }
            }
        }
    }
}
