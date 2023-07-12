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
    private val ingoingSubscriptionsStorage: IngoingSubscriptionsStorage,
    private val currentUserKey: Key
): SubscriptionsRepository {
    override fun subscribe(publisher: Key) {
        CoroutineScope(Dispatchers.IO).launch {
            outgoingSubscriptionsStorage.put(subscriber = currentUserKey, publisher = publisher)
            ingoingSubscriptionsStorage.put(subscriber = currentUserKey,publisher = publisher)
        }
    }
}