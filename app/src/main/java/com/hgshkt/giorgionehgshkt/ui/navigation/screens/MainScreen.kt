package com.hgshkt.giorgionehgshkt.ui.navigation.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class MainScreen(
    route: String,
    val icon: ImageVector
) : Screen(route) {
    object Profile : MainScreen("profile", Icons.Default.Person)
    object Creating : MainScreen("creating", Icons.Default.Add)
    object Settings : MainScreen("settings", Icons.Default.Settings)
    object Search : MainScreen("search", Icons.Default.Search)
}