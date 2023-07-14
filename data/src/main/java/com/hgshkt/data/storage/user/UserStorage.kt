package com.hgshkt.data.storage.user

import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.data.storage.user.models.StorageUser

interface UserStorage {
    fun save(user: StorageUser, key: StorageUserKey)

    suspend fun get(key: StorageUserKey): StorageUser

    fun delete(key: StorageUserKey)
}