package com.hgshkt.domain.usecases

import com.hgshkt.domain.model.dataModel.Key
import com.hgshkt.domain.model.dataModel.PublicationDownloadData
import com.hgshkt.domain.model.Publication
import com.hgshkt.domain.repository.image.ImageRepository
import com.hgshkt.domain.repository.publication.PublicationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UploadPublicationUseCase(
    private val publicationRepository: PublicationRepository,
    private val imageRepository: ImageRepository,
    private val currentUserKey: Key
) {
    fun execute(data: PublicationDownloadData) {
        CoroutineScope(Dispatchers.IO).launch {
            val uploadedImageInfo = imageRepository.save(data, currentUserKey)

            val publication = Publication(
                photoUrl = uploadedImageInfo.url,
                text = data.description,
                time = data.time
            )
            publicationRepository.upload(publication)
        }
    }
}