package com.hgshkt.giorgionehgshkt.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun SettingsScreen(navController: NavHostController) {

    val viewModel = hiltViewModel<SettingsViewModel>()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                viewModel.deleteAccount()
            }
        ) {
            Text("Delete my Account")
        }

        Button(
            onClick = {
                viewModel.exit()
            }
        ) {
            Text("Exit")
        }
    }
}