package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.model.User
import com.hgshkt.domain.model.dataModel.Key
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class ProfileViewModel @AssistedInject constructor(
    private val profileUseCases: ProfileUseCases,
    @Assisted
    private val userId: String
) : ViewModel() {

    private val _publications: MutableList<Publication> = mutableStateListOf()
    var publications: MutableList<Publication> = _publications

    val user = mutableStateOf(User())

    init {
        viewModelScope.launch {
            launch {
                user.value = profileUseCases.getUserByIdUseCase.execute(userId)
            }
            val key = Key(userId)
            _publications.addAll(profileUseCases.getUserPublicationsUseCase.execute(key))
        }
    }

    fun subscribe() {
        val key = Key(userId)
        profileUseCases.subscribeByKeyUseCase.execute(key)
    }

    @AssistedFactory
    interface Factory {
        fun create(userId: String): ProfileViewModel
    }

    companion object {
        fun provideProfileViewModelFactory(factory: Factory, userId: String) : ViewModelProvider.Factory {
            return object: ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(userId) as T
                }
            }
        }
    }
}