package com.hgshkt.data.storage.user

import com.google.firebase.database.DatabaseReference
import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.data.storage.user.models.StorageUser
import kotlinx.coroutines.tasks.await

class FirebaseUserStorage(
    private val reference: DatabaseReference
) : UserStorage {

    override fun save(user: StorageUser, key: StorageUserKey) {
        reference.child(key.value).setValue(user)
    }

    override suspend fun get(key: StorageUserKey): StorageUser {
        return reference.child(key.value).get().await().getValue(StorageUser::class.java)!!
    }

    override fun delete(key: StorageUserKey) {
        reference.child(key.value).removeValue()
    }
}