package com.hgshkt.domain.usecases

import com.hgshkt.domain.authentication.models.LoginData
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.repository.user.LocalUserRepository

class LoginUseCase(
    private val loginService:  LoginService,
    private val localUserRepository: LocalUserRepository
) {
    fun execute(
        data: LoginData
    ) {
        val key = loginService.login(data)
        localUserRepository.saveCurrentUserKey(key)
    }
}