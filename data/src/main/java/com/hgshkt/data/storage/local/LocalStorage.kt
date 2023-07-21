package com.hgshkt.data.storage.local

import com.hgshkt.data.storage.keys.StorageUserKey

interface LocalStorage {
    fun getCurrentUserKey(): StorageUserKey

    fun saveCurrentUserKey(key: StorageUserKey)
}