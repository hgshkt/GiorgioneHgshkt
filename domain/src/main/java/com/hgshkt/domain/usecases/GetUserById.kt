package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.Key
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.UserRepository

class GetUserById(
    private val repository: UserRepository
) {
    suspend fun execute(userId: String): User {
        val key = Key(value = userId)
        return repository.get(key)
    }
}