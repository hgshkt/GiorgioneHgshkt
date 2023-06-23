package com.hgshkt.domain.usecases

import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.repository.user.LocalUserRepository
import com.hgshkt.domain.repository.user.UserRepository

class DeleteUserByIdUseCase(
    private val remoteRepository: UserRepository,
    private val localRepository: LocalUserRepository
) {
    fun execute() {
        val id = localRepository.getCurrentUserAuthId()
        val key = Key(userId = id)
        remoteRepository.delete(key = key)
    }
}