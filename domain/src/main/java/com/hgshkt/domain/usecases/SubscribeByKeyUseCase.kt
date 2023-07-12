package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.subscriptions.SubscriptionsRepository
import com.hgshkt.domain.repository.user.Key

class SubscribeByKeyUseCase(
    private val repository: SubscriptionsRepository,
    private val currentUserKey: Key
) {
    fun execute(key: Key) {
        repository.subscribe(
            subscriber = currentUserKey,
            publisher = key
        )
    }
}