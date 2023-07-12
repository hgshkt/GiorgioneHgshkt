package com.hgshkt.data.storage.publication

import com.hgshkt.data.repository.remote.publication.model.PublicationKey
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.user.Key

interface PublicationStorage {
    suspend fun getUserPublications(key: Key): List<Publication>?

    fun uploadPublication(
        publication: Publication,
        publicationKey: PublicationKey
    )
}