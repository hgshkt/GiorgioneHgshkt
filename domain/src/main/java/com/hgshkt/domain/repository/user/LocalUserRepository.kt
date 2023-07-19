package com.hgshkt.domain.repository.user

import com.hgshkt.domain.data_model.Key

interface LocalUserRepository {

    fun getCurrentUserKey(): Key

    fun saveCurrentUserKey(key: Key)
}