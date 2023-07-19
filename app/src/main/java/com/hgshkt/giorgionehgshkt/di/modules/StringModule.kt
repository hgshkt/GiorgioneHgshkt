package com.hgshkt.giorgionehgshkt.di.modules

import com.hgshkt.domain.data_model.Key
import com.hgshkt.giorgionehgshkt.di.modules.Name.currentUserKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object StringModule {
    @Provides
    @Named("publicationImagesPath")
    fun providePublicationImagesPath(
        @Named(currentUserKey) key: Key
    ): String {
        return key.authId
    }
}