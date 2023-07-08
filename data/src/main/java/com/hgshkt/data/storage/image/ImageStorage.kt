package com.hgshkt.data.storage.image

import android.net.Uri
import com.hgshkt.domain.repository.image.ImageInfo


interface ImageStorage {
    fun save(uri: Uri): ImageInfo
}