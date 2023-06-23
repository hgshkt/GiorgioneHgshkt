package com.hgshkt.domain.repository.user

import com.hgshkt.domain.model.User

interface LocalUserRepository {
    fun getCurrentUser(): User

    fun saveCurrentUser(user: User)

    fun getCurrentUserAuthId(): String

    fun saveCurrentUserAuthId(id: String)
}