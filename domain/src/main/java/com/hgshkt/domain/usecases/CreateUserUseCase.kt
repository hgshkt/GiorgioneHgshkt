package com.hgshkt.domain.usecases

import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.model.User

class CreateUserUseCase {
    fun execute(
        registrationService: RegistrationService,
        user: User
    ) {
        registrationService.registration(user)
    }
}