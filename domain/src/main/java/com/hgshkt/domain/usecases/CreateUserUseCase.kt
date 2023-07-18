package com.hgshkt.domain.usecases

import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.domain.repository.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateUserUseCase(
    private val registrationService: RegistrationService,
    private val localUserRepository: LocalUserRepository,
    private val remoteUserRepository: UserRepository
) {
    fun execute(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            val key = registrationService.registration(user)
            remoteUserRepository.save(user, key)
            localUserRepository.saveCurrentUserKey(key)
        }
    }
}