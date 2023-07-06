package com.hgshkt.giorgionehgshkt.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.FirebaseAuthenticationService
import com.hgshkt.data.authentication.login.FirebaseLoginService
import com.hgshkt.data.authentication.registration.RegistrationServiceImpl
import com.hgshkt.data.repository.PublicationRepositoryImpl
import com.hgshkt.data.repository.SharedPreferenceRepository
import com.hgshkt.data.repository.UserRepositoryImpl
import com.hgshkt.data.storage.publication.FirebasePublicationStorage
import com.hgshkt.data.storage.publication.PublicationStorage
import com.hgshkt.data.storage.user.FirebaseUserStorage
import com.hgshkt.data.storage.user.UserStorage
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.repository.publication.PublicationRepository
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.domain.repository.user.UserRepository
import com.hgshkt.domain.usecases.CheckAuthenticationUseCase
import com.hgshkt.domain.usecases.CreateUserUseCase
import com.hgshkt.domain.usecases.DeleteUserByIdUseCase
import com.hgshkt.domain.usecases.GetCurrentUserIdUseCase
import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.GetUserPublicationsUseCase
import com.hgshkt.domain.usecases.LoginUseCase
import com.hgshkt.domain.usecases.SignOutUseCase
import com.hgshkt.domain.usecases.UploadPublicationUseCase
import com.hgshkt.giorgionehgshkt.ui.navigation.BottomBarUseCases
import com.hgshkt.giorgionehgshkt.ui.navigation.graphs.root.RootNavigationGraphUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.creating.CreatingUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.login.LoginUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.registration.RegistrationUseCases
import com.hgshkt.giorgionehgshkt.ui.screens.settings.SettingsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideCreatingUseCases(uploadPublicationUseCase: UploadPublicationUseCase): CreatingUseCases {
        return CreatingUseCases(uploadPublicationUseCase)
    }

    @Provides
    fun provideUploadPublicationUseCase(repository: PublicationRepository): UploadPublicationUseCase {
        return UploadPublicationUseCase(repository)
    }

    @Provides
    fun providePublicationRepository(storage: PublicationStorage): PublicationRepository {
        return PublicationRepositoryImpl(storage)
    }

    @Provides
    fun providePublicationStorage(): PublicationStorage {
        return FirebasePublicationStorage()
    }

    @Provides
    fun provideRegistrationUseCases(createUserUseCase: CreateUserUseCase): RegistrationUseCases {
        return RegistrationUseCases(createUserUseCase)
    }

    @Provides
    fun provideCreateUserUseCase(registrationService: RegistrationService): CreateUserUseCase {
        return CreateUserUseCase(registrationService)
    }

    @Provides
    fun provideRegistrationService(
        authService: AuthenticationService,
        repository: UserRepository
    ): RegistrationService {
        return RegistrationServiceImpl(authService, repository)
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
    fun provideUserStorage(): UserStorage {
        return FirebaseUserStorage()
    }

    @Provides
    fun provideGetUserPublicationsUseCase(repository: PublicationRepository): GetUserPublicationsUseCase {
        return GetUserPublicationsUseCase(repository)
    }

    @Provides
    fun provideSettingsUseCases(
        deleteUserByIdUseCase: DeleteUserByIdUseCase,
        signOutUseCase: SignOutUseCase
    ): SettingsUseCases {
        return SettingsUseCases(deleteUserByIdUseCase, signOutUseCase)
    }

    @Provides
    fun provideSignOutUseCase(loginService: LoginService): SignOutUseCase {
        return SignOutUseCase(loginService)
    }

    @Provides
    fun providesDeleteUserByIdUseCase(
        remoteRepository: UserRepository,
        localUserRepository: LocalUserRepository
    ): DeleteUserByIdUseCase {
        return DeleteUserByIdUseCase(remoteRepository, localUserRepository)
    }

    @Provides
    fun provideLocalUserRepository(@ApplicationContext appContext: Context): LocalUserRepository {
        val sharedPreferences =
            appContext.getSharedPreferences("userRepository", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        return SharedPreferenceRepository(sharedPreferences, editor)
    }

    @Provides
    fun provideRootNavigationGraphUseCases(
        checkAuthenticationUseCase: CheckAuthenticationUseCase
    ): RootNavigationGraphUseCases {
        return RootNavigationGraphUseCases(checkAuthenticationUseCase)
    }

    @Provides
    fun provideCheckAuthenticationUseCase(loginService: LoginService): CheckAuthenticationUseCase {
        return CheckAuthenticationUseCase(loginService)
    }

    @Provides
    fun provideBottomBarUseCases(getCurrentUserIdUseCase: GetCurrentUserIdUseCase): BottomBarUseCases {
        return BottomBarUseCases(getCurrentUserIdUseCase)
    }

    @Provides
    fun provideGetCurrentUserIdUseCase(localUserRepository: LocalUserRepository): GetCurrentUserIdUseCase {
        return GetCurrentUserIdUseCase(localUserRepository)
    }
}