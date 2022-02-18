package com.beaverlisk.android.compose.ui.navigation

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.beaverlisk.android.compose.ui.theme.AppThemeCompose

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        MainNavigationRoute.Home,
        MainNavigationRoute.Bank,
    )
    BottomNavigation(
        contentColor = contentColorFor(AppThemeCompose.AppColors.primaryTextColor),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = it.icon), contentDescription = stringResource(it.title)) },
                label = { Text(text = stringResource(it.title)) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    /* Add code later */
                }
            )
        }
    }
}