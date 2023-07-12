package com.hgshkt.data.storage.subscription

import com.google.firebase.database.DatabaseReference
import com.hgshkt.domain.repository.user.Key
import kotlinx.coroutines.tasks.await

class FirebaseOutgoingSubscriptionsStorage(
    private val ref: DatabaseReference
) : OutgoingSubscriptionsStorage {

    override suspend fun put(subscriber: Key, publisher: Key) {
        val outgoingSubscriptions = get(subscriber).toMutableList()
        outgoingSubscriptions.add(publisher)

        val idList = outgoingSubscriptions.map { it.authId }

        ref.child(subscriber.authId).setValue(idList)
    }

    override suspend fun get(subscriber: Key): List<Key> {
        val keyValues = ref.child(subscriber.authId)
            .get()
            .await()
            .getValue(listOf<String>()::class.java) ?: listOf()

        return keyValues.map {
            Key(it)
        }
    }
}