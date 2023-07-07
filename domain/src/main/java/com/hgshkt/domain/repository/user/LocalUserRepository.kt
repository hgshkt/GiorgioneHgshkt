package com.hgshkt.domain.repository.user

interface LocalUserRepository {

    fun getCurrentUserKey(): Key

    fun saveCurrentUserKey(key: Key)
}