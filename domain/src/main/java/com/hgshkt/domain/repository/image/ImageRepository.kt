package com.hgshkt.domain.repository.image

import java.io.File

interface ImageRepository {
    suspend fun save(imageFile: File, path: String): ImageInfo
}