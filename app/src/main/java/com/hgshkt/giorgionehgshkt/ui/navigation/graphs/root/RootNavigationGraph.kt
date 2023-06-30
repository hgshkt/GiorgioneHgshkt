package com.hgshkt.giorgionehgshkt.ui.navigation.graphs.root

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hgshkt.giorgionehgshkt.ui.navigation.AppBottomNavigation
import com.hgshkt.giorgionehgshkt.ui.navigation.graphs.auth.authNavGraph

@Composable
fun RootNavigationGraph(navHostController: NavHostController) {

    val viewModel = viewModel<RootNavigationGraphViewModel>()

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = viewModel.startDestination
    ) {
        authNavGraph(navHostController)
        composable(route = Graph.MAIN) {
            AppBottomNavigation(navGraphController = navHostController)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val MAIN = "main_graph"
}