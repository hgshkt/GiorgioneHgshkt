package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.hgshkt.domain.model.User

@Composable
fun ProfileScreen(
    userId: String
) {
    val viewModel = remember {
        ProfileViewModel(
            userId = userId
        )
    }
    val user = viewModel.user.collectAsState(initial = User())
    Text("name: ${user.value.name}")
}