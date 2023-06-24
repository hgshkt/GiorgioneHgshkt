package com.hgshkt.giorgionehgshkt.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.Screen
import com.hgshkt.giorgionehgshkt.ui.screens.creating.CreatingScreen
import com.hgshkt.giorgionehgshkt.ui.screens.login.LoginScreen
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileScreen
import com.hgshkt.giorgionehgshkt.ui.screens.registration.RegistrationScreen
import com.hgshkt.giorgionehgshkt.ui.screens.settings.SettingsScreen

private const val currentUserId = "l0rCBGOi9cb8p7XC9noRU7GCYMD2"

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = MainScreen.Profile.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            startDestination = Screen.Login.route,
            route = "auth"
        ) {
            composable(Screen.Login.route) {
                LoginScreen()
            }
            composable(Screen.Registration.route) {
                RegistrationScreen()
            }
        }
        composable(MainScreen.Profile.route) { ProfileScreen(currentUserId) }
        composable(MainScreen.Creating.route) { CreatingScreen() }
        composable(MainScreen.Settings.route) { SettingsScreen() }
    }
}