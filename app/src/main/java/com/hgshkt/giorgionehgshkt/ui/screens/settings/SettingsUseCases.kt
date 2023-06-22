package com.hgshkt.giorgionehgshkt.ui.screens.settings

import com.hgshkt.domain.usecases.DeleteUserByIdUseCase
import com.hgshkt.domain.usecases.SignOutUseCase

data class SettingsUseCases(
    val deleteUserByIdUseCase: DeleteUserByIdUseCase,
    val signOutUseCase: SignOutUseCase
)
