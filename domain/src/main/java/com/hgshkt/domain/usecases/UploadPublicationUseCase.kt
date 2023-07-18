package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.image.ImageRepository
import com.hgshkt.domain.repository.publication.PublicationRepository
import com.hgshkt.domain.repository.user.Key
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

class UploadPublicationUseCase(
    private val publicationRepository: PublicationRepository,
    private val imageRepository: ImageRepository,
    private val currentUserKey: Key
) {
    fun execute(imageFile: File, publication: Publication) {
        CoroutineScope(Dispatchers.IO).launch {
            val uploadedImageInfo = imageRepository.save(imageFile, currentUserKey)
            publication.photoUrl = uploadedImageInfo.url
            publicationRepository.upload(publication)
        }
    }
}