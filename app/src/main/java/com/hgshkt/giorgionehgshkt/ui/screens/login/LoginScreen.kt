package com.hgshkt.giorgionehgshkt.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hgshkt.giorgionehgshkt.ui.navigation.graphs.root.Graph
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.AuthScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController
) {

    val viewModel = hiltViewModel<LoginViewModel>()

    val email = viewModel.email
    val password = viewModel.password

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.login()
            navController.navigate(Graph.MAIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }
        Button(onClick = {
            navController.navigate(AuthScreen.Registration.route)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register")
        }
    }
}