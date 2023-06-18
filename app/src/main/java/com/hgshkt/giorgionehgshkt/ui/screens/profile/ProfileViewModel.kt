package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.model.User
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel(
    private val userId: String
) : ViewModel() {

    @Inject
    lateinit var profileUseCases: ProfileUseCases

    private val _publications: MutableList<Publication> = mutableStateListOf()
    var publications: MutableList<Publication> = _publications

    val user = mutableStateOf(User())

    init {
        viewModelScope.launch {
            launch {
                user.value = profileUseCases.getUserByIdUseCase.execute(userId)
            }
            _publications.addAll(profileUseCases.getUserPublicationsUseCase.execute(userId))
        }
    }
}