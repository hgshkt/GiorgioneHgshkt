package com.hgshkt.data.repository

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.hgshkt.data.registration.RegistrationService
import com.hgshkt.data.registration.models.RegistrationData
import com.hgshkt.data.storage.FirebaseUserStorage
import com.hgshkt.data.storage.models.StorageUser
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepositoryImpl(
    private val registrationService: RegistrationService
): UserRepository {

    private val storage = FirebaseUserStorage(
        reference = Firebase.database.getReference("users")
    )

    override fun create(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = getRegistrationData(user)
            val registrationUser = registrationService.create(data)

            val storageUser = mapToStorage(user = user)
            storage.save(storageUser, registrationUser.id)
        }
    }

    private fun getRegistrationData(user: User): RegistrationData {
        return RegistrationData(
            email = user.email,
            password = user.password
        )
    }

    private fun mapToStorage(user: User): StorageUser {
        return StorageUser(
            name = user.name,
            id = user.id,
            email = user.email,
            password = user.password
        )
    }
}