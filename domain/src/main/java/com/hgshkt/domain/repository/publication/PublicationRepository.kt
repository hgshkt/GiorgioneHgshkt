package com.hgshkt.domain.repository.publication

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.user.Key

interface PublicationRepository {
    suspend fun getUserPublications(key: Key): List<Publication>

    fun upload(publication: Publication)
}