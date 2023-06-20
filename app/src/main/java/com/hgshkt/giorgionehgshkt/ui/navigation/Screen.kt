package com.hgshkt.giorgionehgshkt.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val icon: ImageVector,
) {
    object Profile : Screen("profile", Icons.Default.Person)
    object Creating : Screen("creating", Icons.Default.Add)
}