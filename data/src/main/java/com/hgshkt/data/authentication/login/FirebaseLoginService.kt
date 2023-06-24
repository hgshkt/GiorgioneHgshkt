package com.hgshkt.data.authentication.login

import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.models.AuthLoginData
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.authentication.models.LoginData


class FirebaseLoginService(
    private val auth: AuthenticationService
): LoginService {


    override fun isSigned(): Boolean {
        return auth.isSigned()
    }


    override fun login(data: LoginData) {
        val loginData = mapToAuthLoginData(data)
        auth.login(loginData)
    }

    override fun signOut() {
        auth.signOut()
    }

    private fun mapToAuthLoginData(data: LoginData): AuthLoginData {
        return AuthLoginData(
            email = data.email,
            password = data.password
        )
    }
}