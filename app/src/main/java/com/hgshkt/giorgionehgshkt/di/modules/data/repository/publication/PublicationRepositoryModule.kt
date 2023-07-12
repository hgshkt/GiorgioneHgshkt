package com.hgshkt.giorgionehgshkt.di.modules.data.repository.publication

import com.hgshkt.data.repository.remote.publication.PublicationRepositoryImpl
import com.hgshkt.data.storage.publication.FirebasePublicationStorage
import com.hgshkt.data.storage.publication.PublicationStorage
import com.hgshkt.domain.repository.publication.PublicationRepository
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.giorgionehgshkt.di.modules.Name.currentUserKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object PublicationRepositoryModule {
    @Provides
    fun providePublicationRepository(
        storage: PublicationStorage,
        @Named(currentUserKey) key: Key
    ): PublicationRepository {
        return PublicationRepositoryImpl(storage, key)
    }

    @Provides
    fun providePublicationStorage(): PublicationStorage {
        return FirebasePublicationStorage()
    }
}