package com.hgshkt.domain.usecases

import com.hgshkt.domain.authentication.LoginService

class CheckAuthenticationUseCase(
    private val loginService: LoginService
) {
    fun execute() : Boolean {
        return loginService.isSigned()
    }
}