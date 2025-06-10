package com.aytbyz.waterbuddy

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.aytbyz.waterbuddy.presentation.navigation.BaseScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = BaseScreen.Home.route,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(BaseScreen.Home.route) {  }
        composable(BaseScreen.History.route) { }
        composable(BaseScreen.Profile.route) { }
    }
}
