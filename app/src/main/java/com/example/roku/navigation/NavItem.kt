package com.example.roku.navigation

import com.example.roku.R

sealed class NavItem(val route: String, val icon: Int, val label: String) {
    data object Discover : NavItem(NavDestinations.DEVICES, R.drawable.ic_device, "Devices")
    data object Remote : NavItem(NavDestinations.REMOTE_SCREEN, R.drawable.ic_remote, "Remote")
    data object Cast : NavItem(NavDestinations.CAST_SCREEN, R.drawable.ic_apps, "Apps")
    data object Settings : NavItem(NavDestinations.SETTINGS_SCREEN, R.drawable.ic_settings, "Settings")
}

val navItems = listOf(
    NavItem.Discover,
    NavItem.Remote,
    NavItem.Cast,
    NavItem.Settings
)