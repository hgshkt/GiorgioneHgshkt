package com.hgshkt.giorgionehgshkt.di.modules.data.auth

import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.FirebaseAuthenticationService
import com.hgshkt.data.authentication.login.FirebaseLoginService
import com.hgshkt.data.authentication.registration.RegistrationServiceImpl
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.authentication.RegistrationService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthBindingModule {
    @Binds
    @Singleton
    abstract fun bindLoginService(
        firebaseLoginService: FirebaseLoginService
    ): LoginService

    @Binds
    @Singleton
    abstract fun bindRegistrationService(
        registrationServiceImpl: RegistrationServiceImpl
    ): RegistrationService

    @Binds
    @Singleton
    abstract fun bindAuthenticationService(
        firebaseAuthenticationService: FirebaseAuthenticationService
    ): AuthenticationService
}