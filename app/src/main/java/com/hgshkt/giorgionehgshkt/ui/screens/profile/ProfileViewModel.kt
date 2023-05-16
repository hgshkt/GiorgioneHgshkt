package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.lifecycle.ViewModel
import com.hgshkt.data.repository.UserRepositoryImpl
import com.hgshkt.data.storage.publication.PublicationRepositoryImpl
import com.hgshkt.domain.usecases.GetUserById
import com.hgshkt.domain.usecases.GetUserPublicationsById
import kotlinx.coroutines.flow.flow

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

    val user = flow {
        val user = profileUseCases.getUserById.execute(userId)
        emit(user)
    }
}