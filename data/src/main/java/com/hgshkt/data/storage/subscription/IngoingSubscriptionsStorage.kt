package com.hgshkt.data.storage.subscription

import com.hgshkt.domain.repository.user.Key

interface IngoingSubscriptionsStorage {
    suspend fun put(subscriber: Key, publisher: Key)

    suspend fun get(publisher: Key): List<Key>
}