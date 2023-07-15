package com.hgshkt.data.storage.subscription

import com.google.firebase.database.DatabaseReference
import com.hgshkt.data.storage.keys.StorageUserKey
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseIngoingSubscriptionsStorage @Inject constructor(
    private val ref: DatabaseReference
): IngoingSubscriptionsStorage {
    override suspend fun put(subscriber: StorageUserKey, publisher: StorageUserKey) {
        val ingoingSubscriptions = get(publisher).toMutableList()
        ingoingSubscriptions.add(subscriber)

        val idList = ingoingSubscriptions.map { it.value }

        ref.child(publisher.value).setValue(idList)
    }

    override suspend fun get(publisher: StorageUserKey): List<StorageUserKey> {
        val keyValues = ref.child(publisher.value)
            .get()
            .await()
            .getValue(listOf<String>()::class.java) ?: listOf()

        return keyValues.map {
            StorageUserKey(it)
        }
    }
}