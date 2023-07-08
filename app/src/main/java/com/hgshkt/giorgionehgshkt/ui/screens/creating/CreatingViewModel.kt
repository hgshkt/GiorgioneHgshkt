package com.hgshkt.giorgionehgshkt.ui.screens.creating

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hgshkt.domain.model.Publication
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import java.lang.System.currentTimeMillis
import javax.inject.Inject

@HiltViewModel
class CreatingViewModel @Inject constructor(
    private val creatingUseCases: CreatingUseCases
): ViewModel() {

    val text = mutableStateOf("")
    val uri = mutableStateOf(Uri.EMPTY)

    fun uploadPublication() {
        val path = uri.value.path ?: "image not selected" // change to notification

        val publication = Publication(
            text = text.value,
            time = currentTimeMillis()
        )
        creatingUseCases.uploadPublicationUseCase.execute(
            imageFile = File(path),
            publication = publication
        )
    }

    fun close() {

    }
}