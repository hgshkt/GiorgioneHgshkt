package com.hgshkt.giorgionehgshkt.di.modules.data.repository.user

import com.hgshkt.data.repository.remote.user.UserRepositoryImpl
import com.hgshkt.data.storage.user.FirebaseUserStorage
import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.domain.repository.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UserRepositoryBindingModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindUserStorage(
        firebaseUserStorage: FirebaseUserStorage
    ): UserStorage
}