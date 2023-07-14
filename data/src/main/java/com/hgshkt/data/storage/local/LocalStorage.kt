package com.hgshkt.data.storage.local

import com.hgshkt.domain.repository.user.Key

interface LocalStorage {
    fun getCurrentUserKey(): Key

    fun saveCurrentUserKey(key: Key)
}