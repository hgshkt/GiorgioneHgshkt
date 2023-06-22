package com.hgshkt.domain.repository.user

import com.hgshkt.domain.model.User

interface UserRepository {
    fun save(user: User, key: Key)

    suspend fun get(key: Key): User

    fun delete(key: Key)
}