package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun ProfileScreen(
    userId: String
) {
    val viewModel = remember {
        ProfileViewModel(
            userId = userId
        )
    }
    val userState = viewModel.userState

    Text("name: ${userState.value.name}")
}