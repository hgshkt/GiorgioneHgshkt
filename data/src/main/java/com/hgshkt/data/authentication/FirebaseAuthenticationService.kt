package com.hgshkt.data.authentication

import com.google.firebase.auth.FirebaseAuth
import com.hgshkt.data.authentication.models.AuthLoginData
import com.hgshkt.data.authentication.models.RegistrationData
import com.hgshkt.data.authentication.models.RegistrationInfo
import kotlinx.coroutines.tasks.await

class FirebaseAuthenticationService: AuthenticationService {

    private val auth = FirebaseAuth.getInstance()

    override suspend fun registration(data: RegistrationData): RegistrationInfo {
        val id = auth.createUserWithEmailAndPassword(data.email, data.password)
            .await().user!!.uid

        return RegistrationInfo(
            id = id
        )
    }

    override fun login(data: AuthLoginData) {
        auth.signInWithEmailAndPassword(data.email, data.password)
    }
}