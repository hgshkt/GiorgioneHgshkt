package com.hgshkt.giorgionehgshkt.ui.navigation.screens

sealed class Screen(
    val route: String
) {
    object Login: Screen("login")
    object Registration: Screen("registration")
}
