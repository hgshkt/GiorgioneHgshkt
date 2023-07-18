package com.hgshkt.data.authentication.registration

import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.models.RegistrationData
import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.model.User
import javax.inject.Inject

class RegistrationServiceImpl @Inject constructor(
    private val authService: AuthenticationService
) : RegistrationService {

    override suspend fun registration(user: User): Key {
        val data = getRegistrationDataByUser(user)
        val registrationInfo = authService.registration(data)

        return Key(authId = registrationInfo.id)
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