package com.hgshkt.giorgionehgshkt.ui.screens.profile

import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.GetUserPublicationsUseCase

data class ProfileUseCases(
    val getUserByIdUseCase: GetUserByIdUseCase,
    val getUserPublicationsUseCase: GetUserPublicationsUseCase
)
