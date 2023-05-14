package com.hgshkt.giorgionehgshkt.ui.screens.registration

import com.hgshkt.domain.usecases.CreateUserUseCase

data class RegistrationUseCases(
    val createUserUseCase: CreateUserUseCase = CreateUserUseCase()
)
