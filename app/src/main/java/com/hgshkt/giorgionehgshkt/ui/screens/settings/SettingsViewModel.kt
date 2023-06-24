package com.hgshkt.giorgionehgshkt.ui.screens.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val useCases: SettingsUseCases
) : ViewModel() {

    fun deleteAccount() {
        useCases.deleteUserByIdUseCase.execute()
    }

    fun exit() {
        useCases.signOutUseCase.execute()
    }
}