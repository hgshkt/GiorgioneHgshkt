package com.hgshkt.giorgionehgshkt.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.ParamType
import com.hgshkt.giorgionehgshkt.ui.screens.creating.CreatingScreen
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileScreen
import com.hgshkt.giorgionehgshkt.ui.screens.search.SearchScreen
import com.hgshkt.giorgionehgshkt.ui.screens.settings.SettingsScreen

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
        composable(
            route = MainScreen.Profile.route,
            arguments = listOf(
                navArgument(ParamType.UserId.name) {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            ProfileScreen(
                userId = it.arguments?.getString(ParamType.UserId.name)!!
            )
        }
        composable(MainScreen.Creating.route) { CreatingScreen() }
        composable(MainScreen.Settings.route) { SettingsScreen(navGraphController) }
        composable(MainScreen.Search.route) { SearchScreen(navController) }
    }
}