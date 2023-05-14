package com.hgshkt.data.registration

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.hgshkt.data.registration.models.RegistrationData
import com.hgshkt.data.registration.models.RegistrationUser
import kotlinx.coroutines.tasks.await

class FirebaseAuthenticationService : RegistrationService {

    private val auth = Firebase.auth

    override suspend fun create(data: RegistrationData): RegistrationUser {
        val id = auth.createUserWithEmailAndPassword(data.email, data.password)
            .await().user!!.uid

        return RegistrationUser(
            email = data.email,
            password = data.password,
            id = id
        )
    }
}