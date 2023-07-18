package com.hgshkt.domain.repository.image

import com.hgshkt.domain.repository.user.Key
import java.io.File

interface ImageRepository {
    suspend fun save(imageFile: File, key: Key): ImageInfo
}