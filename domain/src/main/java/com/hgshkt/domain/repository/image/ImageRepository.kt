package com.hgshkt.domain.repository.image

import com.hgshkt.domain.data_model.ImageInfo
import com.hgshkt.domain.data_model.Key
import com.hgshkt.domain.data_model.PublicationDownloadData

interface ImageRepository {
    suspend fun save(data: PublicationDownloadData, key: Key): ImageInfo
}