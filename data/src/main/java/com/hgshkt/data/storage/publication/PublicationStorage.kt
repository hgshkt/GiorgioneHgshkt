package com.hgshkt.data.storage.publication

import com.hgshkt.domain.model.Publication

interface PublicationStorage {
    suspend fun getUserPublications(userId: String): List<Publication>?
}