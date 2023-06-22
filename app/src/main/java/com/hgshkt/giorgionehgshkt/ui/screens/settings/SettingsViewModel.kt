package com.hgshkt.giorgionehgshkt.ui.screens.settings

import androidx.lifecycle.ViewModel

class SettingsViewModel(
    private val useCases: SettingsUseCases
) : ViewModel() {

    fun deleteAccount() {
        useCases.deleteUserByIdUseCase.execute()
    }

    fun exit() {
        useCases.signOutUseCase.execute()
    }
}