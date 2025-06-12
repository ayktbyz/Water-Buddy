package com.aytbyz.waterbuddy.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BaseScreen(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    data object Home : BaseScreen(
        route = "home",
        label = "Anasayfa",
        icon = Icons.Filled.Home
    )

    data object History : BaseScreen(
        route = "history",
        label = "Geçmiş",
        icon = Icons.Filled.DateRange
    )
}