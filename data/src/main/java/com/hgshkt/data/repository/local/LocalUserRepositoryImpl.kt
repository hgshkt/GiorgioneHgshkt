package com.hgshkt.data.repository.local

import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.data.storage.local.LocalStorage
import com.hgshkt.domain.model.dataModel.Key
import com.hgshkt.domain.repository.user.LocalUserRepository
import javax.inject.Inject

class LocalUserRepositoryImpl @Inject constructor(
    private val localStorage: LocalStorage
) : LocalUserRepository {
    override fun getCurrentUserKey(): Key {
        return localStorage.getCurrentUserKey().toDomain()
    }

    override fun saveCurrentUserKey(key: Key) {
        localStorage.saveCurrentUserKey(key.toStorage())
    }

    private fun StorageUserKey.toDomain(): Key {
        return Key(authId = value)
    }

    private fun Key.toStorage(): StorageUserKey {
        return StorageUserKey(value = authId)
    }
}