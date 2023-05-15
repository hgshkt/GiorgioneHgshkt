package com.hgshkt.giorgionehgshkt.ui.screens.login

import com.hgshkt.data.authentication.login.FirebaseLoginService
import com.hgshkt.domain.usecases.LoginUseCase

data class LoginUseCases(
    val loginUseCase: LoginUseCase = LoginUseCase(loginService = FirebaseLoginService())
)
