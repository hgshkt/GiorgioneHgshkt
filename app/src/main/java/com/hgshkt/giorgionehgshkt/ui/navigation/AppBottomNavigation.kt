package com.hgshkt.giorgionehgshkt.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hgshkt.giorgionehgshkt.ui.navigation.graphs.main.MainNavGraph
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen

private val screens = listOf(
    MainScreen.Search,
    MainScreen.Creating,
    MainScreen.Profile,
    MainScreen.Settings
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomNavigation(
    navGraphController: NavHostController,
    navController: NavHostController = rememberNavController()
) {
    val viewModel = hiltViewModel<BottomNavigationViewModel>()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry = navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry.value?.destination
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            val path = viewModel.getPath(screen)

                            navController.navigate(path) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        MainNavGraph(
            navGraphController = navGraphController,
            navController = navController
        )
    }
}