package com.hgshkt.data.repository.remote.subscription

import com.hgshkt.data.storage.subscription.IngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.OutgoingSubscriptionsStorage
import com.hgshkt.domain.repository.subscriptions.SubscriptionsRepository
import com.hgshkt.domain.repository.user.Key
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscriptionsRepositoryImpl(
    private val outgoingSubscriptionsStorage: OutgoingSubscriptionsStorage,
    private val ingoingSubscriptionsStorage: IngoingSubscriptionsStorage
): SubscriptionsRepository {
    override fun subscribe(subscriber: Key, publisher: Key) {
        CoroutineScope(Dispatchers.IO).launch {
            outgoingSubscriptionsStorage.put(subscriber = subscriber, publisher = publisher)
            ingoingSubscriptionsStorage.put(subscriber = subscriber, publisher = publisher)
        }
    }
}