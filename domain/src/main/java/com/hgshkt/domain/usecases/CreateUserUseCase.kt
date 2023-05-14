package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.UserRepository

class CreateUserUseCase {
    fun execute(
        repository: UserRepository,
        user: User
    ) {
        repository.create(user)
    }
}