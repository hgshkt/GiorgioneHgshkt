package com.hgshkt.giorgionehgshkt.di.modules.data.repository

import com.hgshkt.giorgionehgshkt.di.modules.data.repository.image.ImageRepositoryModule
import com.hgshkt.giorgionehgshkt.di.modules.data.repository.publication.PublicationRepositoryModule
import com.hgshkt.giorgionehgshkt.di.modules.data.repository.repository.SubscriptionsRepositoryModule
import com.hgshkt.giorgionehgshkt.di.modules.data.repository.user.UserRepositoryModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    UserRepositoryModule::class,
    PublicationRepositoryModule::class,
    ImageRepositoryModule::class,
    SubscriptionsRepositoryModule::class
])
@InstallIn(SingletonComponent::class)
object RepositoryModule