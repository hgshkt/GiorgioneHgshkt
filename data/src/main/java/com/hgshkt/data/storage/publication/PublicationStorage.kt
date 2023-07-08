package com.hgshkt.data.storage.publication

import com.hgshkt.data.repository.remote.publication.model.PublicationKey
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.user.Key

interface PublicationStorage {
    suspend fun getUserPublications(userId: String): List<Publication>?

    fun uploadPublication(
        publication: Publication,
        currentUserKey: Key,
        publicationKey: PublicationKey
    )
}