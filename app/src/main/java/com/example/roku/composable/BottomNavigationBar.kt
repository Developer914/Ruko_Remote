package com.example.roku.composable

import android.content.Context
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.roku.navigation.navItems
import com.example.roku.ui.theme.BackgroundColor
import com.example.roku.ui.theme.LightGreyColor

@Composable
fun BottomNavigationBar(navController: NavHostController, applicationContext: Context) {
    NavigationBar(
        containerColor = BackgroundColor
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = if (currentRoute == item.route) Color.White else LightGreyColor
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 11.43.sp,
                        color = if (currentRoute == item.route) Color.White else LightGreyColor
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent  // removes the default background under selected item
                )
            )
        }
    }
}
