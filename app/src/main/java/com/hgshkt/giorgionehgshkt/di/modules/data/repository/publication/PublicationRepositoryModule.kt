package com.hgshkt.giorgionehgshkt.di.modules.data.repository.publication

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.storage.publication.FirebasePublicationStorage
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.giorgionehgshkt.di.modules.Name
import com.hgshkt.giorgionehgshkt.di.modules.Name.publicationReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object PublicationRepositoryModule {

    private const val publicationPath = "publications"

    @Provides
    fun provideFirebasePublicationStorage(
        @Named(publicationReference) reference: DatabaseReference,
        @Named(Name.currentUserKey) currentUserKey: Key
    ): FirebasePublicationStorage {
        return FirebasePublicationStorage(reference, currentUserKey)
    }

    @Provides
    @Named(publicationReference)
    fun providePublicationReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(publicationPath)
    }
}