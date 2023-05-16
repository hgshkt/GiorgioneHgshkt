package com.hgshkt.data.storage.publication

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.PublicationRepository

class PublicationRepositoryImpl: PublicationRepository {
    override fun getUserPublications(userId: String): List<Publication> {
        TODO("Not yet implemented")
    }
}