package com.hgshkt.data.storage.subscription

import com.google.firebase.database.DatabaseReference
import com.hgshkt.domain.repository.user.Key
import kotlinx.coroutines.tasks.await

class FirebaseIngoingSubscriptionsStorage(
    private val ref: DatabaseReference
): IngoingSubscriptionsStorage {
    override suspend fun put(subscriber: Key, publisher: Key) {
        val ingoingSubscriptions = get(publisher).toMutableList()
        ingoingSubscriptions.add(subscriber)

        val idList = ingoingSubscriptions.map { it.authId }

        ref.child(publisher.authId).setValue(idList)
    }

    override suspend fun get(publisher: Key): List<Key> {
        val keyValues = ref.child(publisher.authId)
            .get()
            .await()
            .getValue(listOf<String>()::class.java) ?: listOf()

        return keyValues.map {
            Key(it)
        }
    }
}