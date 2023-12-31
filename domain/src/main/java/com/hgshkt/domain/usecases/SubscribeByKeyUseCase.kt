package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.subscriptions.SubscriptionsRepository
import com.hgshkt.domain.model.dataModel.Key

class SubscribeByKeyUseCase(
    private val repository: SubscriptionsRepository
) {
    fun execute(key: Key) {
        repository.subscribe(publisher = key)
    }
}