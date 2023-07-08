package com.hgshkt.giorgionehgshkt.di.modules

import com.hgshkt.giorgionehgshkt.di.modules.app.ScreensUseCasesModule
import com.hgshkt.giorgionehgshkt.di.modules.data.AuthModule
import com.hgshkt.giorgionehgshkt.di.modules.data.RepositoryModule
import com.hgshkt.giorgionehgshkt.di.modules.domain.UseCaseModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [
    UseCaseModule::class,
    RepositoryModule::class,
    AuthModule::class,
    ScreensUseCasesModule::class
])
@InstallIn(SingletonComponent::class)
object AppModule {

}