package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.image.ImageRepository
import com.hgshkt.domain.repository.publication.PublicationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class UploadPublicationUseCase(
    private val publicationRepository: PublicationRepository,
    private val imageRepository: ImageRepository,
    private val path: String
) {
    fun execute(imageFile: File, publication: Publication) {
        CoroutineScope(Dispatchers.IO).launch {
            val uploadedImageInfo = imageRepository.save(imageFile, path)
            publication.photoUrl = uploadedImageInfo.url
            publicationRepository.upload(publication)
        }
    }
}