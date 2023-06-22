package com.hgshkt.data.repository

import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.data.storage.user.models.StorageUser
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.user.UserRepository

class UserRepositoryImpl(
    private val storage: UserStorage
) : UserRepository {

    override fun save(user: User, key: Key) {
        val storageUser = mapToStorage(user)
        storage.save(storageUser, key.userId)
    }

    override suspend fun get(key: Key): User {
        val storageUser = storage.get(key.userId)
        return mapToDomain(storageUser)
    }

    override fun delete(key: Key) {
        storage.delete(key.userId)
    }

    private fun mapToDomain(storageUser: StorageUser): User {
        return User(
            name = storageUser.name,
            id = storageUser.id,
            email = storageUser.email,
            password = storageUser.password,
            avatarUrl = storageUser.avatarUrl
        )
    }

    private fun mapToStorage(user: User): StorageUser {
        return StorageUser(
            name = user.name,
            id = user.id,
            email = user.email,
            password = user.password,
            avatarUrl = user.avatarUrl
        )
    }
}