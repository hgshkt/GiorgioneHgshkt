package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.publication.PublicationRepository
import com.hgshkt.domain.data_model.Key

class GetUserPublicationsUseCase(
    private val publicationRepository: PublicationRepository
) {
    suspend fun execute(key: Key): List<Publication> {
        return publicationRepository.getUserPublications(key)
    }
}