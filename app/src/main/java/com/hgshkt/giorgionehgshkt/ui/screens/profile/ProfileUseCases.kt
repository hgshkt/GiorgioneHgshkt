package com.hgshkt.giorgionehgshkt.ui.screens.profile

import com.hgshkt.domain.usecases.GetUserByIdUseCase
import com.hgshkt.domain.usecases.GetUserPublicationsUseCase
import com.hgshkt.domain.usecases.SubscribeByKeyUseCase

data class ProfileUseCases(
    val getUserByIdUseCase: GetUserByIdUseCase,
    val getUserPublicationsUseCase: GetUserPublicationsUseCase,
    val subscribeByKeyUseCase: SubscribeByKeyUseCase
)
