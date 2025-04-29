package com.example.roku.navigation

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.roku.screens.home.HomeScreen
import com.example.roku.screens.onboarding.OnboardingScreen
import com.example.roku.util.ext.AppPrefes

@Composable
fun NavHostContainer(applicationContext: Context) {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.padding(),
        navController = navController,
        startDestination = if (AppPrefes.isOnboardingVisited())
            NavDestinations.HOME_SCREEN
        else
            NavDestinations.ONBOARDING_SCREEN
    ) {
        composable(
            route = NavDestinations.ONBOARDING_SCREEN,
            content = { OnboardingScreen(applicationContext, navController) }
        )
        composable(
            route = NavDestinations.HOME_SCREEN,
            content = { HomeScreen(applicationContext,navController) }
        )
    }
}