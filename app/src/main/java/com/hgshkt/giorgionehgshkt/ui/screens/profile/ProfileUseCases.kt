package com.hgshkt.giorgionehgshkt.ui.screens.profile

import com.hgshkt.domain.usecases.GetUserById
import com.hgshkt.domain.usecases.GetUserPublications

data class ProfileUseCases(
    val getUserById: GetUserById,
    val getUserPublications: GetUserPublications
)
