package com.hgshkt.data.authentication.registration

import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.models.RegistrationData
import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationServiceImpl(
    private val authService: AuthenticationService,
    private val repository: UserRepository
) : RegistrationService {

    override fun registration(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = getRegistrationDataByUser(user)
            val registrationInfo = authService.registration(data)

            val key = Key(userId = registrationInfo.id)
            repository.save(user, key)
        }
    }

    private fun getRegistrationDataByUser(user: User): RegistrationData {
        return RegistrationData(
            name = user.name,
            id = user.id,
            email = user.email,
            password = user.password
        )
    }
}