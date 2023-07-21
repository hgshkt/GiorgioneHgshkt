package com.hgshkt.domain.repository.user

import com.hgshkt.domain.model.dataModel.Key

interface LocalUserRepository {

    fun getCurrentUserKey(): Key

    fun saveCurrentUserKey(key: Key)
}