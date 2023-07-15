package com.hgshkt.giorgionehgshkt.di.modules.data.repository.image

import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ImageRepositoryModule {

    private const val referencePath = "images"

    @Provides
    fun provideImageStorageReference(): StorageReference {
        return FirebaseStorage.getInstance().getReference(referencePath)
    }
}