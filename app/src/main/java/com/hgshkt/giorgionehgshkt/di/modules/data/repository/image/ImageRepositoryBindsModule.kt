package com.hgshkt.giorgionehgshkt.di.modules.data.repository.image

import com.hgshkt.data.repository.remote.image.ImageRepositoryImpl
import com.hgshkt.data.storage.image.ImageStorage
import com.hgshkt.data.storage.image.ImageStorageImpl
import com.hgshkt.domain.repository.image.ImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ImageRepositoryBindsModule {
    @Binds
    @Singleton
    abstract fun bindImageRepository(
        imageRepositoryImpl: ImageRepositoryImpl
    ): ImageRepository

    @Binds
    @Singleton
    abstract fun bindImageStorage(
        imageStorageImpl: ImageStorageImpl
    ): ImageStorage
}