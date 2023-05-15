package com.hgshkt.data.authentication.login

import com.hgshkt.data.authentication.FirebaseAuthenticationService
import com.hgshkt.data.authentication.models.AuthLoginData
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.authentication.models.LoginData


class FirebaseLoginService: LoginService {

    private val auth = FirebaseAuthenticationService()

    override fun login(data: LoginData) {
        val loginData = mapToAuthLoginData(data)
        auth.login(loginData)
    }

    private fun mapToAuthLoginData(data: LoginData): AuthLoginData {
        return AuthLoginData(
            email = data.email,
            password = data.password
        )
    }
}