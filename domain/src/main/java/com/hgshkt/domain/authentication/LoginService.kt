package com.hgshkt.domain.authentication

import com.hgshkt.domain.authentication.models.LoginData

interface LoginService {
    fun login(data: LoginData)
}