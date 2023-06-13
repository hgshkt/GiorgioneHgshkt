package com.hgshkt.giorgionehgshkt.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hgshkt.domain.authentication.models.LoginData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
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