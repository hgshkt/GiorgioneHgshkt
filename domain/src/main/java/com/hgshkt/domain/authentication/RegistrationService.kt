package com.hgshkt.domain.authentication

import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.user.Key

interface RegistrationService {
    suspend fun registration(user: User): Key
}