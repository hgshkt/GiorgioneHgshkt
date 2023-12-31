package com.hgshkt.data.repository.remote.subscription

import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.data.storage.subscription.IngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.OutgoingSubscriptionsStorage
import com.hgshkt.domain.repository.subscriptions.SubscriptionsRepository
import com.hgshkt.domain.model.dataModel.Key
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscriptionsRepositoryImpl(
    private val outgoingSubscriptionsStorage: OutgoingSubscriptionsStorage,
    private val ingoingSubscriptionsStorage: IngoingSubscriptionsStorage,
    private val currentUserKey: Key
) : SubscriptionsRepository {
    override fun subscribe(publisher: Key) {
        val subscriberStorageKey = currentUserKey.toStorage()
        val publisherStorageKey = publisher.toStorage()

        CoroutineScope(Dispatchers.IO).launch {
            outgoingSubscriptionsStorage.put(
                subscriber = subscriberStorageKey,
                publisher = publisherStorageKey
            )
            ingoingSubscriptionsStorage.put(
                subscriber = subscriberStorageKey,
                publisher = publisherStorageKey
            )
        }
    }

    private fun Key.toStorage() = StorageUserKey(authId)
}