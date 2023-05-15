package com.hgshkt.giorgionehgshkt.ui.screens.registration

import com.hgshkt.domain.model.User
import org.junit.Test

class RegistrationViewModelTest {

    lateinit var viewModel: RegistrationViewModel

    private val user = User(
        name = "test user name",
        id = "testUserId",
        email = "test1email@gmail.com",
        password = "testpassword111"
    )

    @Test
    fun `user registration`() {
        viewModel = RegistrationViewModel(
            registrationUseCases = RegistrationUseCases()
        )

        viewModel.name.value = user.name
        viewModel.id.value = user.id
        viewModel.email.value = user.email
        viewModel.password.value = user.password

        viewModel.registration()
    }
}