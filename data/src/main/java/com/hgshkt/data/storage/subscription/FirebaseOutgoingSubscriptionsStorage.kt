package com.hgshkt.data.storage.subscription

import com.google.firebase.database.DatabaseReference
import com.hgshkt.data.storage.keys.StorageUserKey
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseOutgoingSubscriptionsStorage @Inject constructor(
    private val ref: DatabaseReference
) : OutgoingSubscriptionsStorage {

    override suspend fun put(subscriber: StorageUserKey, publisher: StorageUserKey) {
        val outgoingSubscriptions = get(subscriber).toMutableList()
        outgoingSubscriptions.add(publisher)

        val idList = outgoingSubscriptions.map { it.value }

        ref.child(subscriber.value).setValue(idList)
    }

    override suspend fun get(subscriber: StorageUserKey): List<StorageUserKey> {
        val keyValues = ref.child(subscriber.value)
            .get()
            .await()
            .getValue(listOf<String>()::class.java) ?: listOf()

        return keyValues.map {
            StorageUserKey(it)
        }
    }
}