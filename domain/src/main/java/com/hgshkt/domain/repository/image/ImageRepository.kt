package com.hgshkt.domain.repository.image

import com.hgshkt.domain.model.dataModel.ImageInfo
import com.hgshkt.domain.model.dataModel.Key
import com.hgshkt.domain.model.dataModel.PublicationDownloadData

interface ImageRepository {
    suspend fun save(data: PublicationDownloadData, key: Key): ImageInfo
}