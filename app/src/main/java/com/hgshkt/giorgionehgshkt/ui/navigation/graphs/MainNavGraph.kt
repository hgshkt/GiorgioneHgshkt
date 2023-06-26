package com.hgshkt.giorgionehgshkt.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen
import com.hgshkt.giorgionehgshkt.ui.screens.creating.CreatingScreen
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileScreen
import com.hgshkt.giorgionehgshkt.ui.screens.settings.SettingsScreen

private val currentUserId = ""

@Composable
fun MainNavGraph(
    navGraphController: NavHostController,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = MainScreen.Settings.route
    ) {
        composable(MainScreen.Profile.route) { ProfileScreen(currentUserId) }
        composable(MainScreen.Creating.route) { CreatingScreen() }
        composable(MainScreen.Settings.route) { SettingsScreen(navGraphController) }
    }
}