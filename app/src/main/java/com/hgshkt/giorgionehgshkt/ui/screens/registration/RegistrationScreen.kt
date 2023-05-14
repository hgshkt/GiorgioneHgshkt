package com.hgshkt.giorgionehgshkt.ui.screens.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.hgshkt.data.registration.FirebaseAuthenticationService
import com.hgshkt.data.repository.UserRepositoryImpl

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen() {
    val repository = UserRepositoryImpl(
        registrationService = FirebaseAuthenticationService()
    )
    val registrationUseCases = RegistrationUseCases()

    val viewModel = remember {
        RegistrationViewModel(
            repository = repository,
            registrationUseCases = registrationUseCases
        )
    }

    var name = viewModel.name.value
    var id = viewModel.id.value
    var email = viewModel.email.value
    var password = viewModel.password.value

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "ID") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.registration()
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Register")
        }
    }

}