package com.hgshkt.domain.repository

import com.hgshkt.domain.model.Publication

interface PublicationRepository {
    suspend fun getUserPublications(userId: String): List<Publication>
}