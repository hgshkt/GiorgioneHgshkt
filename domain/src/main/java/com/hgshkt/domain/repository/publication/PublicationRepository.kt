package com.hgshkt.domain.repository.publication

import com.hgshkt.domain.model.Publication

interface PublicationRepository {
    suspend fun getUserPublications(userId: String): List<Publication>

    fun upload(publication: Publication)
}