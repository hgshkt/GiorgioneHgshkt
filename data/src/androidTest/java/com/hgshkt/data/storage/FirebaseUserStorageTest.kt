package com.hgshkt.data.storage

import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.storage.user.FirebaseUserStorage
import com.hgshkt.data.storage.user.models.StorageUser
import org.junit.Before
import org.junit.Test

class FirebaseUserStorageTest {

    lateinit var storage: FirebaseUserStorage

    @Before
    fun setUp() {
        storage = FirebaseUserStorage(
            reference = FirebaseDatabase.getInstance().getReference("testUser")
        )
    }

    @Test
    fun save() {
        storage.save(
            user = StorageUser(
                name = "test name",
                id = "testId",
                email = "testemail@gmail.com",
                password = "11111111"
            ),
            key = "storageTestKey"
        )
    }
}