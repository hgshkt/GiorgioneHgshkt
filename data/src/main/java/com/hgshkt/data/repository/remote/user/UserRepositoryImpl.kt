package com.hgshkt.data.repository.remote.user

import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.data.storage.user.models.StorageUser
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.repository.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val storage: UserStorage
) : UserRepository {

    override fun save(user: User, key: Key) {
        val storageUser = mapToStorage(user)
        val storageKey = mapDomainKeyToStorageKey(key)

        storage.save(storageUser, storageKey)
    }

    override suspend fun get(key: Key): User {
        val storageKey = mapDomainKeyToStorageKey(key)
        val storageUser = storage.get(storageKey)
        return mapToDomain(storageUser)
    }

    override fun delete(key: Key) {
        val storageKey = mapDomainKeyToStorageKey(key)
        storage.delete(storageKey)
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

    private fun mapDomainKeyToStorageKey(key: Key): StorageUserKey {
        return StorageUserKey(key.authId)
    }
}