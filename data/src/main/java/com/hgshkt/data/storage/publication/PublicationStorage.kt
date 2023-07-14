package com.hgshkt.data.storage.publication

import com.hgshkt.data.repository.remote.publication.model.PublicationKey
import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.domain.model.Publication

interface PublicationStorage {
    suspend fun getUserPublications(key: StorageUserKey): List<Publication>?

    fun uploadPublication(
        publication: Publication,
        publicationKey: PublicationKey
    )
}