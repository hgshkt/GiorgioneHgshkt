package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.PublicationRepository

class GetUserPublicationsById(
    private val publicationRepository: PublicationRepository
) {
    fun execute(userId: String): List<Publication> {
        return publicationRepository.getUserPublications(userId)
    }
}