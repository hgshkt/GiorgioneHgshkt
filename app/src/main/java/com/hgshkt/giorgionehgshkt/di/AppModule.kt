package com.hgshkt.giorgionehgshkt.di

import com.google.firebase.auth.FirebaseAuth
import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.FirebaseAuthenticationService
import com.hgshkt.data.authentication.login.FirebaseLoginService
import com.hgshkt.data.repository.PublicationRepositoryImpl
import com.hgshkt.data.repository.UserRepositoryImpl
import com.hgshkt.data.storage.publication.FirebasePublicationStorage
import com.hgshkt.data.storage.publication.PublicationStorage
import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.repository.publication.PublicationRepository
import com.hgshkt.domain.repository.user.UserRepository
import com.hgshkt.domain.usecases.CreateUserUseCase
import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.GetUserPublicationsUseCase
import com.hgshkt.domain.usecases.LoginUseCase
import com.hgshkt.domain.usecases.UploadPublicationUseCase
import com.hgshkt.giorgionehgshkt.ui.screens.creating.CreatingUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.login.LoginUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.registration.RegistrationUseCases
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
        return LoginUseCase(loginService)
    }

    @Provides
    fun provideLoginService(auth: AuthenticationService): LoginService {
        return FirebaseLoginService(auth)
    }

    @Provides
    fun provideAuthenticationService(auth: FirebaseAuth): AuthenticationService {
        return FirebaseAuthenticationService(auth)
    }

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideCreatingUseCases(uploadPublicationUseCase: UploadPublicationUseCase): CreatingUseCases{
        return CreatingUseCases(uploadPublicationUseCase)
    }

    @Provides
    fun provideUploadPublicationUseCase(repository: PublicationRepository): UploadPublicationUseCase{
        return UploadPublicationUseCase(repository)
    }

    @Provides
    fun providePublicationRepository(storage: PublicationStorage): PublicationRepository {
        return PublicationRepositoryImpl(storage)
    }

    @Provides
    fun providePublicationStorage():PublicationStorage{
        return FirebasePublicationStorage()
    }

    @Provides
    fun provideRegistrationUseCases(createUserUseCase: CreateUserUseCase): RegistrationUseCases {
        return RegistrationUseCases(createUserUseCase)
    }

    @Provides
    fun provideCreateUserUseCase(): CreateUserUseCase {
        return CreateUserUseCase()
    }

    @Provides
    fun provideProfileUseCases(
        getUserByIdUseCase: GetUserByIdUseCase,
        getUserPublicationsUseCase: GetUserPublicationsUseCase
    ): ProfileUseCases {
        return ProfileUseCases(getUserByIdUseCase, getUserPublicationsUseCase)
    }

    @Provides
    fun provideGetUserByIdUseCase(repository: UserRepository): GetUserByIdUseCase {
        return GetUserByIdUseCase(repository)
    }

    @Provides
    fun provideUserRepository(storage: UserStorage): UserRepository {
        return UserRepositoryImpl(storage)
    }

    @Provides
    fun provideGetUserPublicationsUseCase(repository: PublicationRepository): GetUserPublicationsUseCase {
        return GetUserPublicationsUseCase(repository)
    }
}