package com.hgshkt.data.authentication

import com.hgshkt.data.authentication.models.AuthLoginData
import com.hgshkt.data.authentication.models.RegistrationData
import com.hgshkt.data.authentication.models.RegistrationInfo

interface AuthenticationService {

    fun isSigned(): Boolean

    suspend fun registration(data: RegistrationData): RegistrationInfo

    fun login(data: AuthLoginData)

    fun signOut()
}