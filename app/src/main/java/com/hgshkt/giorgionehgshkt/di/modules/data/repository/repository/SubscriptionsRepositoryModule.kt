package com.hgshkt.giorgionehgshkt.di.modules.data.repository.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.repository.remote.subscription.SubscriptionsRepositoryImpl
import com.hgshkt.data.storage.subscription.FirebaseIngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.FirebaseOutgoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.IngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.OutgoingSubscriptionsStorage
import com.hgshkt.domain.repository.subscriptions.SubscriptionsRepository
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.giorgionehgshkt.di.modules.Name
import com.hgshkt.giorgionehgshkt.di.modules.Name.ingoingSubscriptionsReference
import com.hgshkt.giorgionehgshkt.di.modules.Name.outgoingSubscriptionsReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object SubscriptionsRepositoryModule {

    private const val outgoingSubscriptionsPath = "outgoingSubscriptions"
    private const val ingoingSubscriptionsPath = "ingoingSubscriptions"
    @Provides
    fun provideSubscriptionsRepository(
        outgoingSubscriptionsStorage: OutgoingSubscriptionsStorage,
        ingoingSubscriptionsStorage: IngoingSubscriptionsStorage,
        @Named(Name.currentUserKey) currentUserKey: Key
    ): SubscriptionsRepository {
        return SubscriptionsRepositoryImpl(
            outgoingSubscriptionsStorage = outgoingSubscriptionsStorage,
            ingoingSubscriptionsStorage = ingoingSubscriptionsStorage,
            currentUserKey = currentUserKey
        )
    }

    @Provides
    fun provideOutgoingSubscriptionsStorage(
        @Named(outgoingSubscriptionsReference) reference: DatabaseReference
    ): OutgoingSubscriptionsStorage {
        return FirebaseOutgoingSubscriptionsStorage(reference)
    }

    @Provides
    fun provideIngoingSubscriptionsStorage(
        @Named(ingoingSubscriptionsReference) reference: DatabaseReference
    ): IngoingSubscriptionsStorage {
        return FirebaseIngoingSubscriptionsStorage(reference)
    }

    @Provides
    @Named(outgoingSubscriptionsReference)
    fun provideOutgoingSubscriptionsReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(outgoingSubscriptionsPath)
    }

    @Provides
    @Named(ingoingSubscriptionsReference)
    fun provideIngoingSubscriptionsReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(ingoingSubscriptionsPath)
    }
}