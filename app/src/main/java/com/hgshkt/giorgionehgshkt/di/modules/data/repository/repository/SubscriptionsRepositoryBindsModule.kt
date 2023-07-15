package com.hgshkt.giorgionehgshkt.di.modules.data.repository.repository

import com.hgshkt.data.repository.remote.subscription.SubscriptionsRepositoryImpl
import com.hgshkt.data.storage.subscription.FirebaseIngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.FirebaseOutgoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.IngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.OutgoingSubscriptionsStorage
import com.hgshkt.domain.repository.subscriptions.SubscriptionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SubscriptionsRepositoryBindsModule {
    @Binds
    @Singleton
    abstract fun bindSubscriptionsRepository(
        subscriptionsRepositoryImpl: SubscriptionsRepositoryImpl
    ): SubscriptionsRepository

    @Binds
    @Singleton
    abstract fun bindOutgoingSubscriptionsStorage(
        firebaseOutgoingSubscriptionsStorage: FirebaseOutgoingSubscriptionsStorage
    ): OutgoingSubscriptionsStorage

    @Binds
    @Singleton
    abstract fun bindIngoingSubscriptionsStorage(
        firebaseIngoingSubscriptionsStorage: FirebaseIngoingSubscriptionsStorage
    ): IngoingSubscriptionsStorage
}