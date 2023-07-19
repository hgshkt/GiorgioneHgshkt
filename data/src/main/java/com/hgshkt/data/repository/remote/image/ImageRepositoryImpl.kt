package com.hgshkt.data.repository.remote.image

import android.net.Uri
import com.hgshkt.data.storage.image.ImageStorage
import com.hgshkt.domain.data_model.ImageInfo
import com.hgshkt.domain.data_model.Key
import com.hgshkt.domain.data_model.PublicationDownloadData
import com.hgshkt.domain.repository.image.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageStorage: ImageStorage
): ImageRepository {
    override suspend fun save(data: PublicationDownloadData, key: Key): ImageInfo {
        val uri = Uri.parse(data.uriString)
        return imageStorage.save(uri, key)
    }
}