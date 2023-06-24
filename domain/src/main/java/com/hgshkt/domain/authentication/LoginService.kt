package com.hgshkt.domain.authentication

import com.hgshkt.domain.authentication.models.LoginData

interface LoginService {

    fun isSigned(): Boolean

    fun login(data: LoginData)

    fun signOut()
}