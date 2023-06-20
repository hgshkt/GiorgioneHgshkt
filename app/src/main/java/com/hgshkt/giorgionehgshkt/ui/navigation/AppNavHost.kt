package com.hgshkt.giorgionehgshkt.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hgshkt.giorgionehgshkt.ui.screens.creating.CreatingScreen
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileScreen

private const val currentUserId = "l0rCBGOi9cb8p7XC9noRU7GCYMD2"

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Profile.route,
        modifier = modifier
    ) {
        composable(Screen.Profile.route) { ProfileScreen(currentUserId) }
        composable(Screen.Creating.route) { CreatingScreen() }
    }
}