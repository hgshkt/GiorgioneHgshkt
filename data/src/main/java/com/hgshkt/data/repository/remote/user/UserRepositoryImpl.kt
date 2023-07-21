package com.hgshkt.data.repository.remote.user

import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.data.storage.user.models.StorageUser
import com.hgshkt.domain.model.User
import com.hgshkt.domain.model.dataModel.Key
import com.hgshkt.domain.repository.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val storage: UserStorage
) : UserRepository {

    override fun save(user: User, key: Key) {
        storage.save(user.toStorage(), key.toStorage())
    }

    override suspend fun get(key: Key): User {
        val storageUser = storage.get(key.toStorage())
        return storageUser.toDomain()
    }

    override fun delete(key: Key) {
        storage.delete(key.toStorage())
    }

    private fun StorageUser.toDomain(): User {
        return User(
            name = name,
            id = id,
            email = email,
            password = password,
            avatarUrl = avatarUrl
        )
    }

    private fun User.toStorage(): StorageUser {
        return StorageUser(
            name = name,
            id = id,
            email = email,
            password = password,
            avatarUrl = avatarUrl
        )
    }

    private fun Key.toStorage() = StorageUserKey(value = authId)
}