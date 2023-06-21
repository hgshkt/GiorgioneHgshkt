package com.hgshkt.giorgionehgshkt.ui.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SettingsScreen() {

    // val viewModel = ...

    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = {
                // viewModel.deleteAccount()
            }
        ) {
            Text("Delete my Account")
        }

        Button(
            onClick = {
                // viewModel.exit()
            }
        ) {
            Text("Exit")
        }
    }
}