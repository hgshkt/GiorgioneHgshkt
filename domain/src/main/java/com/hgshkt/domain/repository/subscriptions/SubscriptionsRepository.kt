package com.hgshkt.domain.repository.subscriptions

import com.hgshkt.domain.model.dataModel.Key

interface SubscriptionsRepository {
    fun subscribe(publisher: Key)
}