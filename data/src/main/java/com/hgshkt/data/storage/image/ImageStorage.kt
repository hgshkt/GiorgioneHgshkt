package com.hgshkt.data.storage.image

import android.net.Uri
import com.hgshkt.domain.data_model.ImageInfo
import com.hgshkt.domain.data_model.Key


interface ImageStorage {
    suspend fun save(uri: Uri, key: Key): ImageInfo
}