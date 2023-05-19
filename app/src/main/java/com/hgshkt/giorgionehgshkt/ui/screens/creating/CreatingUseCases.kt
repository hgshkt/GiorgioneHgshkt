package com.hgshkt.giorgionehgshkt.ui.screens.creating

import com.hgshkt.data.repository.PublicationRepositoryImpl
import com.hgshkt.data.storage.publication.FirebasePublicationStorage
import com.hgshkt.domain.usecases.UploadPublicationUseCase

data class CreatingUseCases(
    var uploadPublicationUseCase: UploadPublicationUseCase = UploadPublicationUseCase(
        repository = PublicationRepositoryImpl(
            storage = FirebasePublicationStorage()
        )
    )
)