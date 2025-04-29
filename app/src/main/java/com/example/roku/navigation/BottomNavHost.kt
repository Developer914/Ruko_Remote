package com.example.roku.navigation

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.roku.screens.remote.RemoteScreen

@Composable
fun BottomNavHost(
    bottomNavController: NavHostController,
    navController: NavHostController,
    applicationContext: Context
) {
    NavHost(
        modifier = Modifier.padding(),
        navController = bottomNavController,
        startDestination = NavDestinations.REMOTE_SCREEN
    ) {
//        composable(
//            route = NavDestinations.DISCOVER_SCREEN,
//            content = { DiscoverScreen(applicationContext, navController) }
//        )
        composable(
            route = NavDestinations.REMOTE_SCREEN,
            content = {
                RemoteScreen(
//                    navController = navController,
//                    bottomNavController = bottomNavController
                )
            }
        )
//        composable(
//            route = NavDestinations.CAST_SCREEN,
//            content = {
//                CastingScreen()
//            }
//        )
//        composable(
//            route = NavDestinations.SETTINGS_SCREEN,
//            content = { SettingScreen(applicationContext, navController) }
//        )

    }
}