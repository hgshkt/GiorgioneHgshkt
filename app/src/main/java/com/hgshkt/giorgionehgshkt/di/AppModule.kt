package com.hgshkt.giorgionehgshkt.di

import com.hgshkt.data.authentication.login.FirebaseLoginService
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.usecases.LoginUseCase
import com.hgshkt.giorgionehgshkt.ui.screens.login.LoginUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLoginUseCases(loginUseCase: LoginUseCase): LoginUseCases {
        return LoginUseCases(loginUseCase)
    }

    @Provides
    fun provideLoginUseCase(loginService: LoginService): LoginUseCase {
        return LoginUseCase(loginService = loginService)
    }

    @Provides
    fun provideLoginService(): LoginService {
        return FirebaseLoginService()
    }
}