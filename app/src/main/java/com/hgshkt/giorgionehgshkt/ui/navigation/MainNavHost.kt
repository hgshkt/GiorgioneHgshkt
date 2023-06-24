package com.hgshkt.giorgionehgshkt.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen
import com.hgshkt.giorgionehgshkt.ui.screens.creating.CreatingScreen
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileScreen
import com.hgshkt.giorgionehgshkt.ui.screens.settings.SettingsScreen

private const val currentUserId = "l0rCBGOi9cb8p7XC9noRU7GCYMD2"

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = MainScreen.Profile.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(MainScreen.Profile.route) { ProfileScreen(currentUserId) }
        composable(MainScreen.Creating.route) { CreatingScreen() }
        composable(MainScreen.Settings.route) { SettingsScreen() }
    }
}