package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.data.repository.PublicationRepositoryImpl
import com.hgshkt.data.repository.UserRepositoryImpl
import com.hgshkt.data.storage.publication.FirebasePublicationStorage
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.model.User
import com.hgshkt.domain.usecases.GetUserById
import com.hgshkt.domain.usecases.GetUserPublications
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val profileUseCases: ProfileUseCases = ProfileUseCases(
        getUserById = GetUserById(
            repository = UserRepositoryImpl(),
        ),
        getUserPublications = GetUserPublications(
            publicationRepository = PublicationRepositoryImpl(
                storage = FirebasePublicationStorage()
            )
        )
    ),
    private val userId: String
) : ViewModel() {

    private val _publications:MutableList<Publication> = mutableStateListOf()
    var publications: MutableList<Publication> = _publications

    val user = mutableStateOf(User())

    init {
        viewModelScope.launch {
            launch {
                user.value = profileUseCases.getUserById.execute(userId)
                println("qqq: ${user.value.avatarUrl}")
            }
            _publications.addAll(profileUseCases.getUserPublications.execute(userId))
        }

    }
}