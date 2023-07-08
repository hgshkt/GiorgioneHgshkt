package com.hgshkt.giorgionehgshkt.di.modules

import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.giorgionehgshkt.di.modules.app.ScreensUseCasesModule
import com.hgshkt.giorgionehgshkt.di.modules.data.AuthModule
import com.hgshkt.giorgionehgshkt.di.modules.data.RepositoryModule
import com.hgshkt.giorgionehgshkt.di.modules.domain.UseCaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module(includes = [
    UseCaseModule::class,
    RepositoryModule::class,
    AuthModule::class,
    ScreensUseCasesModule::class
])
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Named("userKey")
    fun provideUserKey(localRepository: LocalUserRepository): Key {
        return localRepository.getCurrentUserKey()
    }
}