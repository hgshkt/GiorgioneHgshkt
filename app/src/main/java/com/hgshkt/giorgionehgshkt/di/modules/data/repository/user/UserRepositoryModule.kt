package com.hgshkt.giorgionehgshkt.di.modules.data.repository.user

import android.content.Context
import com.hgshkt.data.repository.local.SharedPreferenceRepository
import com.hgshkt.data.repository.remote.user.UserRepositoryImpl
import com.hgshkt.data.storage.user.FirebaseUserStorage
import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.domain.repository.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryModule {

    private const val userRepository = "userRepository"
    @Provides
    fun provideUserRepository(storage: UserStorage): UserRepository {
        return UserRepositoryImpl(storage)
    }

    @Provides
    fun provideUserStorage(): UserStorage {
        return FirebaseUserStorage()
    }

    @Provides
    fun provideLocalUserRepository(@ApplicationContext appContext: Context): LocalUserRepository {
        val sharedPreferences =
            appContext.getSharedPreferences(userRepository, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        return SharedPreferenceRepository(sharedPreferences, editor)
    }
}