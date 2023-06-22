package com.hgshkt.data.storage.user

import com.hgshkt.data.storage.user.models.StorageUser

interface UserStorage {
    fun save(user: StorageUser, key: String)

    suspend fun get(key: String): StorageUser

    fun delete(key: String)
}