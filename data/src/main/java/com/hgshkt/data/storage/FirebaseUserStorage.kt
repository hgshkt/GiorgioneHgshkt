package com.hgshkt.data.storage

import com.google.firebase.database.DatabaseReference
import com.hgshkt.data.storage.models.StorageUser

class FirebaseUserStorage(
    private val reference: DatabaseReference
): UserStorage {

    override fun save(user: StorageUser, key: String) {
        reference.child(key).setValue(user)
    }
}