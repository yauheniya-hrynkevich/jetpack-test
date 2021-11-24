package com.beaverlisk.android.jetpacktest.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) AppThemeCompose.AppColors.darkColorPalette else AppThemeCompose.AppColors.lightColorPalette,
        typography = AppThemeCompose.TextStyles.typography,
        shapes = AppThemeCompose.Shape.shapes,
        content = content
    )
}

object AppThemeCompose {

    object AppColors {
        val primaryColor = Color(0xFFC62828)
        val primaryLightColor = Color(0xFFFF5F52)
        val primaryDarkColor = Color(0xFF8E0000)
        val primaryTextColor = Color(0xFFFFFFFF)
        val secondaryColor = Color(0xFFB71C1C)
        val secondaryLightColor = Color(0xFFF05545)
        val secondaryDarkColor = Color(0xFF7F0000)
        val secondaryTextColor = Color(0xFFFFFFFF)

        val night_primaryColor = Color(0xFF263238)
        val night_primaryLightColor = Color(0xFF4F5B62)
        val night_primaryDarkColor = Color(0xFF000A12)
        val night_primaryTextColor = Color(0xFFFFFFFF)
        val night_secondaryColor = Color(0xFF212121)
        val night_secondaryLightColor = Color(0xFF484848)
        val night_secondaryDarkColor = Color(0xFF000000)
        val night_secondaryTextColor = Color(0xB5FFFFFF)

        val lightColorPalette = lightColors(
            primary = primaryColor,
            primaryVariant = primaryDarkColor,
            secondary = primaryDarkColor,
            onPrimary = primaryTextColor,
            onSecondary = primaryTextColor
        )

        val darkColorPalette = darkColors(
            primary = night_secondaryColor,
            primaryVariant = night_secondaryLightColor,
            secondary = night_secondaryDarkColor,
            onPrimary = night_secondaryTextColor,
            onSecondary = night_secondaryTextColor
        )
    }

    object TextStyles {

        val typography = Typography(
            body1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            button = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W500,
                fontSize = 14.sp
            ),
            caption = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
            )

        )
    }

    object Shape {

        val shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(4.dp),
            large = RoundedCornerShape(0.dp)
        )
    }
}



