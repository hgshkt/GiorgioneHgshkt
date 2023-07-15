package com.hgshkt.data.authentication

import com.google.firebase.auth.FirebaseAuth
import com.hgshkt.data.authentication.models.AuthLoginData
import com.hgshkt.data.authentication.models.RegistrationData
import com.hgshkt.data.authentication.models.RegistrationInfo
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthenticationService @Inject constructor(
    private val auth: FirebaseAuth
): AuthenticationService {

    override var currentUserId: String = ""
        private set
        get() {
            return auth.currentUser?.uid ?: ""
        }

    override fun isSigned() = auth.currentUser != null

    override suspend fun registration(data: RegistrationData): RegistrationInfo {
        val id = auth.createUserWithEmailAndPassword(data.email, data.password)
            .await().user!!.uid

        return RegistrationInfo(
            id = id
        )
    }

    override fun signOut() {
        auth.signOut()
    }

    override fun login(data: AuthLoginData) {
        auth.signInWithEmailAndPassword(data.email, data.password)
        currentUserId = auth.currentUser!!.uid
    }
}