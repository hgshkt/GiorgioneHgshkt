package com.hgshkt.data.storage.image

import android.net.Uri
import com.hgshkt.domain.repository.image.ImageInfo
import com.hgshkt.domain.repository.user.Key


interface ImageStorage {
    suspend fun save(uri: Uri, key: Key): ImageInfo
}