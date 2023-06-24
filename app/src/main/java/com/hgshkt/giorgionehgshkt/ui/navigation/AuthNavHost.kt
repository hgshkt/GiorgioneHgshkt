package com.hgshkt.giorgionehgshkt.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.AuthScreen
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.Screen
import com.hgshkt.giorgionehgshkt.ui.screens.login.LoginScreen
import com.hgshkt.giorgionehgshkt.ui.screens.registration.RegistrationScreen

@Composable
fun AuthNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AuthScreen.Registration.route
    ) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(Screen.Login.route) {
            LoginScreen()
        }
        composable(Screen.Registration.route) {
            RegistrationScreen()
        }
    }
}