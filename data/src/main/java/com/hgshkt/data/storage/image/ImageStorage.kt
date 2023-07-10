package com.hgshkt.data.storage.image

import android.net.Uri
import com.hgshkt.domain.repository.image.ImageInfo


interface ImageStorage {
    suspend fun save(
        uri: Uri
    ): ImageInfo
}