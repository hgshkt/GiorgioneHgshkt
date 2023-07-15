package com.hgshkt.giorgionehgshkt.di.modules.data.repository.local

import com.hgshkt.data.repository.local.SharedPreferenceRepository
import com.hgshkt.data.storage.local.LocalStorage
import com.hgshkt.data.storage.local.SharedPreferenceStorage
import com.hgshkt.domain.repository.user.LocalUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalRepositoryBindingModule {
    @Binds
    @Singleton
    abstract fun bindLocalUserRepository(
        sharedPreferenceRepository: SharedPreferenceRepository
    ): LocalUserRepository

    @Binds
    @Singleton
    abstract fun bindLocalStorage(
        sharedPreferenceStorage: SharedPreferenceStorage
    ): LocalStorage
}