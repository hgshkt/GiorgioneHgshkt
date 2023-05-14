package com.hgshkt.giorgionehgshkt.ui.screens.registration

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.UserRepository

class RegistrationViewModel(
    private val repository: UserRepository,
    private val registrationUseCases: RegistrationUseCases
) : ViewModel() {

    val name = mutableStateOf("")
    val id = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")

    fun registration() {
        val user = User(
            name = name.value,
            id = id.value,
            email = email.value,
            password = password.value,
        )
        registrationUseCases.createUserUseCase.execute(
            user = user,
            repository = repository
        )
    }
}