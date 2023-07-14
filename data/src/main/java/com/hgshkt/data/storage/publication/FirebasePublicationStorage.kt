package com.hgshkt.data.storage.publication

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.getValue
import com.hgshkt.data.repository.remote.publication.model.PublicationKey
import com.hgshkt.data.storage.keys.StorageUserKey
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.user.Key
import kotlinx.coroutines.tasks.await

class FirebasePublicationStorage(
    private val reference: DatabaseReference,
    private val currentUserKey: Key
): PublicationStorage {

    override suspend fun getUserPublications(key: StorageUserKey): List<Publication>? {
        return reference.child(key.value).get().await().getValue<List<Publication>>()
    }

    override fun uploadPublication(
        publication: Publication,
        publicationKey: PublicationKey
    ) {
        reference.child(currentUserKey.authId).child(publicationKey.time).setValue(publication)
    }
}