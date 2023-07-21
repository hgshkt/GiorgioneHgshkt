package com.hgshkt.data.storage.image

import android.net.Uri
import com.hgshkt.domain.model.dataModel.ImageInfo
import com.hgshkt.domain.model.dataModel.Key


interface ImageStorage {
    suspend fun save(uri: Uri, key: Key): ImageInfo
}