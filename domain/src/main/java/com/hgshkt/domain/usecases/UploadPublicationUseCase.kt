package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.publication.PublicationRepository

class UploadPublicationUseCase(
    private val repository: PublicationRepository
) {
    fun execute(publication: Publication) {
        repository.upload(publication)
    }
}