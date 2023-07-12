package com.hgshkt.giorgionehgshkt.di.modules.domain

import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.repository.image.ImageRepository
import com.hgshkt.domain.repository.publication.PublicationRepository
import com.hgshkt.domain.repository.subscriptions.SubscriptionsRepository
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.domain.repository.user.UserRepository
import com.hgshkt.domain.usecases.CheckAuthenticationUseCase
import com.hgshkt.domain.usecases.CreateUserUseCase
import com.hgshkt.domain.usecases.DeleteUserByIdUseCase
import com.hgshkt.domain.usecases.GetCurrentUserKeyUseCase
import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.GetUserPublicationsUseCase
import com.hgshkt.domain.usecases.LoginUseCase
import com.hgshkt.domain.usecases.SignOutUseCase
import com.hgshkt.domain.usecases.SubscribeByKeyUseCase
import com.hgshkt.domain.usecases.UploadPublicationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideLoginUseCase(
        loginService: LoginService,
        localUserRepository: LocalUserRepository
    ): LoginUseCase {
        return LoginUseCase(loginService, localUserRepository)
    }

    @Provides
    fun provideUploadPublicationUseCase(
        publicationRepository: PublicationRepository,
        imageRepository: ImageRepository,
        @Named("publicationImagesPath") path: String
    ): UploadPublicationUseCase {
        return UploadPublicationUseCase(
            publicationRepository = publicationRepository,
            imageRepository = imageRepository,
            path = path
        )
    }

    @Provides
    fun provideCreateUserUseCase(
        registrationService: RegistrationService
    ): CreateUserUseCase {
        return CreateUserUseCase(registrationService)
    }

    @Provides
    fun provideGetUserByIdUseCase(repository: UserRepository): GetUserByIdUseCase {
        return GetUserByIdUseCase(repository)
    }

    @Provides
    fun provideGetUserPublicationsUseCase(
        repository: PublicationRepository
    ): GetUserPublicationsUseCase {
        return GetUserPublicationsUseCase(repository)
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
    fun provideCheckAuthenticationUseCase(
        loginService: LoginService
    ): CheckAuthenticationUseCase {
        return CheckAuthenticationUseCase(loginService)
    }

    @Provides
    fun provideGetCurrentUserIdUseCase(
        localUserRepository: LocalUserRepository
    ): GetCurrentUserKeyUseCase {
        return GetCurrentUserKeyUseCase(localUserRepository)
    }

    @Provides
    fun provideSubscribeByKeyUseCase(
        repository: SubscriptionsRepository
    ): SubscribeByKeyUseCase {
        return SubscribeByKeyUseCase(repository)
    }
}