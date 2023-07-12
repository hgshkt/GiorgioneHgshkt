package com.hgshkt.domain.repository.subscriptions

import com.hgshkt.domain.repository.user.Key

interface SubscriptionsRepository {
    fun subscribe(subscriber: Key, publisher: Key)
}