package com.hgshkt.domain.repository.subscriptions

import com.hgshkt.domain.data_model.Key

interface SubscriptionsRepository {
    fun subscribe(publisher: Key)
}