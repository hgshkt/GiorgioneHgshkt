package com.hgshkt.domain.repository.image

import java.io.File

interface ImageRepository {
    fun save(imageFile: File): ImageInfo
}