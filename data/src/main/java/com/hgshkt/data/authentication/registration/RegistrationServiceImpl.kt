package com.hgshkt.data.authentication.registration

import com.hgshkt.data.authentication.AuthenticationService
import com.hgshkt.data.authentication.models.RegistrationData
import com.hgshkt.domain.authentication.RegistrationService
import com.hgshkt.domain.model.dataModel.Key
import com.hgshkt.domain.model.User
import javax.inject.Inject

class RegistrationServiceImpl @Inject constructor(
    private val authService: AuthenticationService
) : RegistrationService {

    override suspend fun registration(user: User): Key {
        val data = user.getRegistrationData()
        val registrationInfo = authService.registration(data)

        return Key(authId = registrationInfo.id)
    }

    private fun User.getRegistrationData(): RegistrationData = RegistrationData(
        name = name,
        id = id,
        email = email,
        password = password
    )
}