package com.hgshkt.domain.authentication

import com.hgshkt.domain.authentication.models.LoginData
import com.hgshkt.domain.data_model.Key

interface LoginService {

    fun isSigned(): Boolean

    fun login(data: LoginData): Key

    fun signOut()
}