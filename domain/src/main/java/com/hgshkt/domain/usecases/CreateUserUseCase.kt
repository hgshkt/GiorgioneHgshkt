package com.hgshkt.domain.usecases

import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.model.User

class CreateUserUseCase(
    private val registrationService: RegistrationService,
) {
    fun execute(user: User) {
        registrationService.registration(user)
    }
}