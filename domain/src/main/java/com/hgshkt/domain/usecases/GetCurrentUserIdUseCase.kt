package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.user.LocalUserRepository

class GetCurrentUserIdUseCase(
    private val repository: LocalUserRepository
) {
    fun execute(): String {
        return repository.getCurrentUserAuthId()
    }
}