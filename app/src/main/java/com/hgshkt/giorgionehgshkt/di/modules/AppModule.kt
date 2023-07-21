package com.hgshkt.giorgionehgshkt.di.modules

import com.hgshkt.domain.model.dataModel.Key
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.giorgionehgshkt.di.modules.Name.currentUserKey
import com.hgshkt.giorgionehgshkt.di.modules.app.ScreensUseCasesModule
import com.hgshkt.giorgionehgshkt.di.modules.data.auth.AuthModule
import com.hgshkt.giorgionehgshkt.di.modules.data.repository.RepositoryModule
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
    ScreensUseCasesModule::class,
    StringModule::class
])
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Named(currentUserKey)
    fun provideUserKey(localRepository: LocalUserRepository): Key {
        return localRepository.getCurrentUserKey()
    }
}