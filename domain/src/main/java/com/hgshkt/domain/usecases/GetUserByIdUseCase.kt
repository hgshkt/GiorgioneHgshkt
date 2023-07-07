package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.user.UserRepository

class GetUserByIdUseCase(
    private val repository: UserRepository
) {
    suspend fun execute(userId: String): User {
        val key = Key(authId = userId)
        return repository.get(key)
    }
}