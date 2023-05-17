package com.hgshkt.data.repository

import com.hgshkt.data.storage.publication.PublicationStorage
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.PublicationRepository

class PublicationRepositoryImpl(
    private val storage: PublicationStorage
) : PublicationRepository {

    override suspend fun getUserPublications(userId: String): List<Publication> {
        return storage.getUserPublications(userId) ?: listOf()
    }
}