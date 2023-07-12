package com.hgshkt.data.storage.subscription

import com.hgshkt.domain.repository.user.Key

interface OutgoingSubscriptionsStorage {
    suspend fun put(subscriber: Key, publisher: Key)

    suspend fun get(subscriber: Key): List<Key>
}