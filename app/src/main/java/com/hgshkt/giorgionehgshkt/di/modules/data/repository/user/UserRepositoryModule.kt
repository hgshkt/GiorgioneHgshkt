package com.hgshkt.giorgionehgshkt.di.modules.data.repository.user

import android.content.Context
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.repository.local.SharedPreferenceRepository
import com.hgshkt.data.repository.remote.user.UserRepositoryImpl
import com.hgshkt.data.storage.local.LocalStorage
import com.hgshkt.data.storage.local.SharedPreferenceStorage
import com.hgshkt.data.storage.user.FirebaseUserStorage
import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.domain.repository.user.UserRepository
import com.hgshkt.giorgionehgshkt.di.modules.Name.usersReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryModule {

    private const val userRepository = "userRepository"
    private const val usersPath = "users"

    @Provides
    fun provideUserRepository(storage: UserStorage): UserRepository {
        return UserRepositoryImpl(storage)
    }

    @Provides
    fun provideUserStorage(@Named(usersReference) reference: DatabaseReference): UserStorage {
        return FirebaseUserStorage(reference)
    }

    @Provides
    @Named(usersReference)
    fun provideUserStorageReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(usersPath)
    }

    @Provides
    fun provideLocalUserRepository(storage: LocalStorage): LocalUserRepository {
        return SharedPreferenceRepository(storage)
    }

    @Provides
    fun provideLocalStorage(@ApplicationContext appContext: Context): LocalStorage {
        val sharedPreferences =
            appContext.getSharedPreferences(userRepository, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        return SharedPreferenceStorage(sharedPreferences, editor)
    }
}