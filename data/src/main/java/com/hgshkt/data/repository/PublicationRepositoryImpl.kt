package com.hgshkt.data.repository

import com.hgshkt.data.storage.publication.PublicationStorage
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.publication.PublicationRepository

class PublicationRepositoryImpl(
    private val storage: PublicationStorage
) : PublicationRepository {

    override suspend fun getUserPublications(userId: String): List<Publication> {
        return storage.getUserPublications(userId) ?: listOf()
    }

    override fun upload(publication: Publication) {
        TODO("Not yet implemented")
    }
}