package com.hgshkt.giorgionehgshkt.ui.navigation.screens

sealed class AuthScreen(route: String) : Screen(route) {
    object Login: Screen("login")
    object Registration: Screen("registration")
}