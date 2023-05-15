package com.hgshkt.domain.repository

import com.hgshkt.domain.model.Key
import com.hgshkt.domain.model.User

interface UserRepository {
    fun save(user: User, key: Key)
}