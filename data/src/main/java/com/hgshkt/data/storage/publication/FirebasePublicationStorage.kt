package com.hgshkt.data.storage.publication

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.hgshkt.data.repository.remote.publication.model.PublicationKey
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.user.Key
import kotlinx.coroutines.tasks.await

class FirebasePublicationStorage : PublicationStorage {

    private val reference = FirebaseDatabase.getInstance().getReference("publications")

    override suspend fun getUserPublications(userId: String): List<Publication>? {
        return reference.child(userId).get().await().getValue<List<Publication>>()
    }

    override fun uploadPublication(
        publication: Publication,
        currentUserKey: Key,
        publicationKey: PublicationKey
    ) {
        reference.child(currentUserKey.authId).child(publicationKey.time).setValue(publication)
    }
}