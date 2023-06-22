package com.hgshkt.domain.usecases

import com.hgshkt.domain.authentication.LoginService

class SignOutUseCase(
    private val loginService: LoginService
) {
    fun execute() {
        loginService.signOut()
    }
}