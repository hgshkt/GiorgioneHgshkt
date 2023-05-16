package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.data.repository.UserRepositoryImpl
import com.hgshkt.data.storage.publication.PublicationRepositoryImpl
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.model.User
import com.hgshkt.domain.usecases.GetUserById
import com.hgshkt.domain.usecases.GetUserPublicationsById
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val profileUseCases: ProfileUseCases = ProfileUseCases(
        getUserById = GetUserById(
            repository = UserRepositoryImpl(),
        ),
        getUserPublicationsById = GetUserPublicationsById(
            publicationRepository = PublicationRepositoryImpl()
        )
    ),
    private val userId: String
) : ViewModel() {

    val userState = mutableStateOf(User())
    var publicationListState = mutableStateListOf(Publication())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            launch {
                userState.value = profileUseCases.getUserById.execute(userId)
            }

            val publications = profileUseCases.getUserPublicationsById.execute(userId)
            publicationListState.addAll(publications)
        }
    }
}