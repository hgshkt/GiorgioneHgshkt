package com.hgshkt.domain.repository

import com.hgshkt.domain.model.User

interface UserRepository {
    fun create(user: User)
}