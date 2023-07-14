package com.hgshkt.data.storage.subscription

import com.hgshkt.data.storage.keys.StorageUserKey

interface OutgoingSubscriptionsStorage {
    suspend fun put(subscriber: StorageUserKey, publisher: StorageUserKey)

    suspend fun get(subscriber: StorageUserKey): List<StorageUserKey>
}