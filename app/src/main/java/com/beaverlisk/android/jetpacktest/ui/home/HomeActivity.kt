package com.beaverlisk.android.jetpacktest.ui.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.beaverlisk.android.jetpacktest.ui.bank.BankContentScreen
import com.beaverlisk.android.jetpacktest.ui.bank.BankViewModel
import com.beaverlisk.android.jetpacktest.ui.navigation.BottomNavigationBar
import com.beaverlisk.android.jetpacktest.ui.common.NavigationToolbar
import com.beaverlisk.android.jetpacktest.ui.navigation.MainNavigationRoute
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
