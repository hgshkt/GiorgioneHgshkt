package com.hgshkt.giorgionehgshkt.di.modules.data.repository.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.repository.remote.subscription.SubscriptionsRepositoryImpl
import com.hgshkt.data.storage.subscription.FirebaseIngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.FirebaseOutgoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.IngoingSubscriptionsStorage
import com.hgshkt.data.storage.subscription.OutgoingSubscriptionsStorage
import com.hgshkt.domain.model.dataModel.Key
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
    fun provideSubscriptionsRepositoryImpl(
        outgoingSubscriptionsStorage: OutgoingSubscriptionsStorage,
        ingoingSubscriptionsStorage: IngoingSubscriptionsStorage,
        @Named(Name.currentUserKey) currentUserKey: Key
    ): SubscriptionsRepositoryImpl {
        return SubscriptionsRepositoryImpl(
            outgoingSubscriptionsStorage = outgoingSubscriptionsStorage,
            ingoingSubscriptionsStorage = ingoingSubscriptionsStorage,
            currentUserKey = currentUserKey
        )
    }

    @Provides
    fun provideFirebaseOutgoingSubscriptionsStorage(
        @Named(outgoingSubscriptionsReference) reference: DatabaseReference
    ): FirebaseOutgoingSubscriptionsStorage {
        return FirebaseOutgoingSubscriptionsStorage(reference)
    }

    @Provides
    fun provideFirebaseIngoingSubscriptionsStorage(
        @Named(ingoingSubscriptionsReference) reference: DatabaseReference
    ): FirebaseIngoingSubscriptionsStorage {
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