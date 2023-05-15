package com.hgshkt.data.storage.repository

import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.storage.FirebaseUserStorage
import com.hgshkt.data.storage.models.StorageUser
import com.hgshkt.domain.model.Key
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    private val storage = FirebaseUserStorage(
        reference = FirebaseDatabase.getInstance().getReference("users")
    )

    override fun save(user: User, key: Key) {
        val storageUser = mapToStorage(user)
        storage.save(storageUser, key.value)
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