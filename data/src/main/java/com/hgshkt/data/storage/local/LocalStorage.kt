package com.hgshkt.data.storage.local

import com.hgshkt.domain.data_model.Key

interface LocalStorage {
    fun getCurrentUserKey(): Key

    fun saveCurrentUserKey(key: Key)
}