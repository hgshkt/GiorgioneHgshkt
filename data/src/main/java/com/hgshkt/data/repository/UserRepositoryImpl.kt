package com.hgshkt.data.repository

import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.storage.user.FirebaseUserStorage
import com.hgshkt.data.storage.user.models.StorageUser
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

    override suspend fun get(key: Key): User {
        val storageUser = storage.get(key.value)
        return mapToDomain(storageUser)
    }

    private fun mapToDomain(storageUser: StorageUser): User {
        return User(
            name = storageUser.name,
            id = storageUser.id,
            email = storageUser.email,
            password = storageUser.password,
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