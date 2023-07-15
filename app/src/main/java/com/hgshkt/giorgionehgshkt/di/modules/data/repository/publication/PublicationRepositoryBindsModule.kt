package com.hgshkt.giorgionehgshkt.di.modules.data.repository.publication

import com.hgshkt.data.repository.remote.publication.PublicationRepositoryImpl
import com.hgshkt.data.storage.publication.FirebasePublicationStorage
import com.hgshkt.data.storage.publication.PublicationStorage
import com.hgshkt.domain.repository.publication.PublicationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PublicationRepositoryBindsModule {
    @Binds
    @Singleton
    abstract fun bindPublicationRepository(
        publicationRepositoryImpl: PublicationRepositoryImpl
    ): PublicationRepository

    @Binds
    @Singleton
    abstract fun bindPublicationStorage(
        firebasePublicationStorage: FirebasePublicationStorage
    ): PublicationStorage
}