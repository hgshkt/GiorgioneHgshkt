package com.hgshkt.domain.authentication

import com.hgshkt.domain.authentication.models.LoginData
import com.hgshkt.domain.model.dataModel.Key

interface LoginService {

    fun isSigned(): Boolean

    fun login(data: LoginData): Key

    fun signOut()
}