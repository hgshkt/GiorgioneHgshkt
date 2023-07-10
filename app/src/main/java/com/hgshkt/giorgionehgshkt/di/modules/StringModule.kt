package com.hgshkt.giorgionehgshkt.di.modules

import com.hgshkt.domain.repository.user.Key
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
        @Named("currentUserKey") key: Key
    ): String {
        return key.authId
    }
}