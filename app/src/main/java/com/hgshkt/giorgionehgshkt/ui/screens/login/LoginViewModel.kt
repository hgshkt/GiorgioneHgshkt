package com.hgshkt.giorgionehgshkt.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hgshkt.domain.authentication.models.LoginData

class LoginViewModel(
    private val loginUseCases: LoginUseCases = LoginUseCases()
): ViewModel() {
    val email = mutableStateOf("")
    val password = mutableStateOf("")

    fun login() {
        val data = LoginData(
            email = email.value,
            password = password.value
        )

        loginUseCases.loginUseCase.execute(
            data = data
        )
    }
}