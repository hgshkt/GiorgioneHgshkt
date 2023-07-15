package com.hgshkt.giorgionehgshkt.di.modules.data.repository.user

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hgshkt.data.storage.user.FirebaseUserStorage
import com.hgshkt.giorgionehgshkt.di.modules.Name.usersReference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
object UserRepositoryModule {

    private const val usersPath = "users"

    @Provides
    fun provideFirebaseUserStorage(
        @Named(usersReference) reference: DatabaseReference
    ): FirebaseUserStorage {
        return FirebaseUserStorage(reference)
    }
    @Provides
    @Named(usersReference)
    fun provideUserStorageReference(): DatabaseReference {
        return FirebaseDatabase.getInstance().getReference(usersPath)
    }
}