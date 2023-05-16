package com.hgshkt.data.storage.user

import com.google.firebase.database.DatabaseReference
import com.hgshkt.data.storage.user.models.StorageUser
import kotlinx.coroutines.tasks.await

class FirebaseUserStorage(
    private val reference: DatabaseReference
): UserStorage {

    override fun save(user: StorageUser, key: String) {
        reference.child(key).setValue(user)
    }

    override suspend fun get(key: String): StorageUser {
        return reference.child(key).get().await().getValue(StorageUser::class.java)!!
    }
}