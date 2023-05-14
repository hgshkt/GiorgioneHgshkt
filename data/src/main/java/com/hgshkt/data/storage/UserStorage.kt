package com.hgshkt.data.storage

import com.hgshkt.data.storage.models.StorageUser

interface UserStorage {
    fun save(user: StorageUser, key: String)
}