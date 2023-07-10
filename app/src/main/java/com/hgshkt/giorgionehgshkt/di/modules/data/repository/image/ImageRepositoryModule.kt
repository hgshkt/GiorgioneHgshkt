package com.hgshkt.giorgionehgshkt.di.modules.data.repository.image

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.hgshkt.data.repository.remote.image.ImageRepositoryImpl
import com.hgshkt.data.storage.image.ImageStorage
import com.hgshkt.data.storage.image.ImageStorageImpl
import com.hgshkt.domain.repository.image.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ImageRepositoryModule {

    private const val referencePath = "images"

    @Provides
    fun provideImageRepository(imageStorage: ImageStorage): ImageRepository {
        return ImageRepositoryImpl(imageStorage)
    }

    @Provides
    fun provideImageStorage(reference: StorageReference): ImageStorage {
        return ImageStorageImpl(reference)
    }

    @Provides
    fun provideImageStorageReference(): StorageReference {
        return FirebaseStorage.getInstance().getReference(referencePath)
    }
}