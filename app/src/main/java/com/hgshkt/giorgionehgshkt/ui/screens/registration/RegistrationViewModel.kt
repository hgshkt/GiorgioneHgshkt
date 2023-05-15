package com.hgshkt.giorgionehgshkt.ui.screens.registration

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hgshkt.data.authentication.registration.RegistrationServiceImpl
import com.hgshkt.domain.model.User

class RegistrationViewModel(
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
            registrationService = RegistrationServiceImpl()
        )
    }
}