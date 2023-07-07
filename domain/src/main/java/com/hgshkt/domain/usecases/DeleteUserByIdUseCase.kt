package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.domain.repository.user.UserRepository

class DeleteUserByIdUseCase(
    private val remoteRepository: UserRepository,
    private val localRepository: LocalUserRepository
) {
    fun execute() {
        val key = localRepository.getCurrentUserKey()
        remoteRepository.delete(key = key)
    }
}