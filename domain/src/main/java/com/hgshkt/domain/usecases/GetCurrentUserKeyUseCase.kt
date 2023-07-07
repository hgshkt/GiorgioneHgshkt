package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.repository.user.LocalUserRepository

class GetCurrentUserKeyUseCase(
    private val repository: LocalUserRepository
) {
    fun execute(): Key {
        return repository.getCurrentUserKey()
    }
}