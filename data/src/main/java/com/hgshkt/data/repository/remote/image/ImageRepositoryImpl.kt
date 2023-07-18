package com.hgshkt.data.repository.remote.image

import android.net.Uri
import com.hgshkt.data.storage.image.ImageStorage
import com.hgshkt.domain.repository.image.ImageInfo
import com.hgshkt.domain.repository.image.ImageRepository
import com.hgshkt.domain.repository.user.Key
import java.io.File
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageStorage: ImageStorage
): ImageRepository {
    override suspend fun save(imageFile: File, key: Key): ImageInfo {
        val javaUri = imageFile.toURI()
        val androidUri = Uri.parse(javaUri.toString())

        return imageStorage.save(androidUri, key)
    }
}