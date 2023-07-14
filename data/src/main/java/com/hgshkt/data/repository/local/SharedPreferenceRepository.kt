package com.hgshkt.data.repository.local

import com.hgshkt.data.storage.local.LocalStorage
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.repository.user.LocalUserRepository

class SharedPreferenceRepository(
    private val localStorage: LocalStorage
) : LocalUserRepository {
    override fun getCurrentUserKey(): Key {
        return localStorage.getCurrentUserKey()
    }

    override fun saveCurrentUserKey(key: Key) {
        localStorage.saveCurrentUserKey(key)
    }
}