package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.image.ImageRepository
import com.hgshkt.domain.repository.publication.PublicationRepository
import java.io.File

class UploadPublicationUseCase(
    private val publicationRepository: PublicationRepository,
    private val imageRepository: ImageRepository
) {
    fun execute(imageFile: File, publication: Publication) {
        val uploadedImageInfo = imageRepository.save(imageFile)
        publication.photoUrl = uploadedImageInfo.url
        publicationRepository.upload(publication)
    }
}