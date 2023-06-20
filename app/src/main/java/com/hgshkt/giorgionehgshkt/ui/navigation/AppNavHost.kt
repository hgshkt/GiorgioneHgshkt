package com.hgshkt.giorgionehgshkt.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileScreen

private const val currentUserId = "l0rCBGOi9cb8p7XC9noRU7GCYMD2"

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "profile",
        modifier = modifier
    ) {
        composable("profile") { ProfileScreen(currentUserId) }
    }
}