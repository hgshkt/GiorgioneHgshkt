package com.hgshkt.giorgionehgshkt.di.modules.app

import com.hgshkt.domain.usecases.CheckAuthenticationUseCase
import com.hgshkt.domain.usecases.CreateUserUseCase
import com.hgshkt.domain.usecases.DeleteUserByIdUseCase
import com.hgshkt.domain.usecases.GetCurrentUserKeyUseCase
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
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ScreensUseCasesModule {
    @Provides
    fun provideBottomBarUseCases(
        getCurrentUserKeyUseCase: GetCurrentUserKeyUseCase
    ): BottomBarUseCases {
        return BottomBarUseCases(getCurrentUserKeyUseCase)
    }

    @Provides
    fun provideRootNavigationGraphUseCases(
        checkAuthenticationUseCase: CheckAuthenticationUseCase
    ): RootNavigationGraphUseCases {
        return RootNavigationGraphUseCases(checkAuthenticationUseCase)
    }

    @Provides
    fun provideSettingsUseCases(
        deleteUserByIdUseCase: DeleteUserByIdUseCase,
        signOutUseCase: SignOutUseCase
    ): SettingsUseCases {
        return SettingsUseCases(deleteUserByIdUseCase, signOutUseCase)
    }

    @Provides
    fun provideProfileUseCases(
        getUserByIdUseCase: GetUserByIdUseCase,
        getUserPublicationsUseCase: GetUserPublicationsUseCase
    ): ProfileUseCases {
        return ProfileUseCases(getUserByIdUseCase, getUserPublicationsUseCase)
    }

    @Provides
    fun provideRegistrationUseCases(
        createUserUseCase: CreateUserUseCase
    ): RegistrationUseCases {
        return RegistrationUseCases(createUserUseCase)
    }

    @Provides
    fun provideCreatingUseCases(
        uploadPublicationUseCase: UploadPublicationUseCase
    ): CreatingUseCases {
        return CreatingUseCases(uploadPublicationUseCase)
    }

    @Provides
    fun provideLoginUseCases(loginUseCase: LoginUseCase): LoginUseCases {
        return LoginUseCases(loginUseCase)
    }
}