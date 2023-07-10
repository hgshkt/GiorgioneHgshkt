package com.hgshkt.giorgionehgshkt.di.modules.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.FirebaseAuthenticationService
import com.hgshkt.data.authentication.login.FirebaseLoginService
import com.hgshkt.data.authentication.registration.RegistrationServiceImpl
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.repository.user.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    fun provideLoginService(auth: AuthenticationService): LoginService {
        return FirebaseLoginService(auth)
    }

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideRegistrationService(
        authService: AuthenticationService,
        repository: UserRepository
    ): RegistrationService {
        return RegistrationServiceImpl(authService, repository)
    }

    @Provides
    fun provideAuthenticationService(auth: FirebaseAuth): AuthenticationService {
        return FirebaseAuthenticationService(auth)
    }
}