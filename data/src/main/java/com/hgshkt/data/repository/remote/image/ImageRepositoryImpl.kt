package com.hgshkt.data.repository.remote.image

import android.net.Uri
import com.hgshkt.data.storage.image.ImageStorage
import com.hgshkt.domain.repository.image.ImageInfo
import com.hgshkt.domain.repository.image.ImageRepository
import java.io.File

class ImageRepositoryImpl(
    private val imageStorage: ImageStorage
): ImageRepository {
    override fun save(imageFile: File): ImageInfo {
        val javaUri = imageFile.toURI()
        val androidUri = Uri.parse(javaUri.toString())

        return imageStorage.save(androidUri)
    }
}