package com.hgshkt.data.repository.remote.publication

import com.hgshkt.data.repository.remote.publication.model.PublicationKey
import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.data.storage.publication.PublicationStorage
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.publication.PublicationRepository
import com.hgshkt.domain.repository.user.Key
import javax.inject.Inject

class PublicationRepositoryImpl @Inject constructor(
    private val storage: PublicationStorage
) : PublicationRepository {

    override suspend fun getUserPublications(key: Key): List<Publication> {
        val storageKey = mapDomainToStorage(key)
        return storage.getUserPublications(storageKey) ?: listOf()
    }

    override fun upload(publication: Publication) {
        val publicationKey = PublicationKey(time = publication.time.toString())

        storage.uploadPublication(
            publication = publication,
            publicationKey = publicationKey
        )
    }

    private fun mapDomainToStorage(key: Key): StorageUserKey {
        return StorageUserKey(key.authId)
    }
}