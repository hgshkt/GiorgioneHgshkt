package com.hgshkt.domain.usecases

import com.hgshkt.domain.authentication.models.LoginData
import com.hgshkt.domain.authentication.LoginService

class LoginUseCase(
    private val loginService:  LoginService
) {
    fun execute(
        data: LoginData
    ) {
        loginService.login(data)
    }
}