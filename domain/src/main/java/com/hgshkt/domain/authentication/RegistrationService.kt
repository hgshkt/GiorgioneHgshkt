package com.hgshkt.domain.authentication

import com.hgshkt.domain.model.User
import com.hgshkt.domain.data_model.Key

interface RegistrationService {
    suspend fun registration(user: User): Key
}