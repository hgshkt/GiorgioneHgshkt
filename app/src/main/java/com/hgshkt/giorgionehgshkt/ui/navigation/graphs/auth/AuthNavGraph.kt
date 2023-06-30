package com.hgshkt.giorgionehgshkt.ui.navigation.graphs.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hgshkt.giorgionehgshkt.ui.navigation.graphs.root.Graph
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.AuthScreen
import com.hgshkt.giorgionehgshkt.ui.screens.login.LoginScreen
import com.hgshkt.giorgionehgshkt.ui.screens.registration.RegistrationScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(AuthScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(AuthScreen.Registration.route) {
            RegistrationScreen(navController)
        }
    }
}