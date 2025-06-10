package com.aytbyz.waterbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aytbyz.waterbuddy.presentation.navigation.BaseScreen
import com.aytbyz.waterbuddy.ui.theme.WaterBuddyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterBuddyTheme {
                val navController = rememberNavController()
                val items = listOf(
                    BaseScreen.Home,
                    BaseScreen.History,
                    BaseScreen.Profile
                )

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            val currentRoute = navController
                                .currentBackStackEntryAsState().value?.destination?.route
                            items.forEach { screen ->
                                NavigationBarItem(
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.startDestinationId) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    label = { Text(screen.label) },
                                    icon = { screen.icon }
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    AppNavGraph(navController, paddingValues)
                }
            }
        }
    }
}