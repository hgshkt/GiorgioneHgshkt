package com.hgshkt.giorgionehgshkt.ui.screens.creating

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hgshkt.domain.model.Publication

class CreatingViewModel(
    private val creatingUseCases: CreatingUseCases = CreatingUseCases()
): ViewModel() {

    val text = mutableStateOf("")
    val url = mutableStateOf("")

    fun uploadPublication() {
        val publication = Publication(
            photoUrl = url.value,
            text = text.value
        )
        creatingUseCases.uploadPublicationUseCase.execute(publication = publication)
    }

    fun close() {

    }
}