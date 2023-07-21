package com.hgshkt.data.authentication.login

import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.models.AuthLoginData
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.authentication.models.LoginData
import com.hgshkt.domain.model.dataModel.Key
import javax.inject.Inject


class FirebaseLoginService @Inject constructor(
    private val auth: AuthenticationService
) : LoginService {

    override fun isSigned(): Boolean {
        return auth.isSigned()
    }


    override fun login(data: LoginData): Key {
        val loginData = data.toAuth()
        auth.login(loginData)

        return Key(authId = auth.currentUserId)
    }

    override fun signOut() {
        auth.signOut()
    }

    private fun LoginData.toAuth() = AuthLoginData(
        email = email,
        password = password
    )
}