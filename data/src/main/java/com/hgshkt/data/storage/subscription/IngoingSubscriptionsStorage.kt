package com.hgshkt.data.storage.subscription

import com.hgshkt.data.storage.keys.StorageUserKey

interface IngoingSubscriptionsStorage {
    suspend fun put(subscriber: StorageUserKey, publisher: StorageUserKey)

    suspend fun get(publisher: StorageUserKey): List<StorageUserKey>
}