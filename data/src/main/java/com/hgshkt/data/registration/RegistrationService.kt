package com.hgshkt.data.registration

import com.hgshkt.data.registration.models.RegistrationData
import com.hgshkt.data.registration.models.RegistrationUser

interface RegistrationService {
    suspend fun create(data: RegistrationData): RegistrationUser
}