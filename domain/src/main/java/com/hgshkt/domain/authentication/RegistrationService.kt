package com.hgshkt.domain.authentication

import com.hgshkt.domain.model.User

interface RegistrationService {
    fun registration(user: User)
}