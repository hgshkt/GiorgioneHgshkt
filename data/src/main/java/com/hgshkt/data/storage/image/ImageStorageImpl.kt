package com.hgshkt.data.storage.image

import android.net.Uri
import com.google.firebase.storage.StorageReference
import com.hgshkt.domain.data_model.ImageInfo
import com.hgshkt.domain.data_model.Key
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ImageStorageImpl @Inject constructor(
    private val reference: StorageReference
) : ImageStorage {
    override suspend fun save(uri: Uri, key: Key): ImageInfo {
        val taskSnapshot = reference.child(key.authId).putFile(uri).await()
        val url = taskSnapshot.storage.downloadUrl.await().toString()

        return ImageInfo(url)
    }
}