package com.beaverlisk.android.compose.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.beaverlisk.android.compose.R

@Composable
fun NavigationToolbar(
    title: String,
    icon: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    textAlign = TextAlign.Start
                )
            },
            backgroundColor = MaterialTheme.colors.primary,
            actions = {
                icon()
            },
            elevation = 0.dp
        )
        Box( ){


        }
        Image(
            painter = painterResource(id = R.drawable.app_bar_red),
            contentDescription = null,
            modifier = Modifier
                .background(Color.Transparent)
        )
    }
}