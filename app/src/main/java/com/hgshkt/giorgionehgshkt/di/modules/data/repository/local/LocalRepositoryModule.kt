package com.hgshkt.giorgionehgshkt.di.modules.data.repository.local

import android.content.Context
import com.hgshkt.data.storage.local.SharedPreferenceStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalRepositoryModule {

    private const val userRepository = "userRepository"

    @Provides
    fun provideSharedPreferenceStorage(@ApplicationContext appContext: Context): SharedPreferenceStorage {
        val sharedPreferences =
            appContext.getSharedPreferences(userRepository, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        return SharedPreferenceStorage(sharedPreferences, editor)
    }
}