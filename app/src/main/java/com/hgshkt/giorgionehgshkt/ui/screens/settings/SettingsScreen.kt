package com.hgshkt.giorgionehgshkt.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsScreen() {

    val viewModel = hiltViewModel<SettingsViewModel>()

    Column(
        verticalArrangement = Arrangement.SpaceBetween
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