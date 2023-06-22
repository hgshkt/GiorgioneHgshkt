package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.user.UserRepository

class DeleteUserByIdUseCase(
    private val repository: UserRepository
) {
    fun execute() {
        repository.delete()
    }
}