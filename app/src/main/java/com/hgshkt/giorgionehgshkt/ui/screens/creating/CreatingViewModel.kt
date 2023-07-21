package com.hgshkt.giorgionehgshkt.ui.screens.creating

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hgshkt.domain.model.dataModel.PublicationDownloadData
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.System.currentTimeMillis
import javax.inject.Inject

@HiltViewModel
class CreatingViewModel @Inject constructor(
    private val creatingUseCases: CreatingUseCases
): ViewModel() {

    val text = mutableStateOf("")
    val uri = mutableStateOf(Uri.EMPTY)

    fun uploadPublication() {
        val data = PublicationDownloadData(
            uriString = uri.value.toString(),
            description = text.value,
            time = currentTimeMillis()
        )
        creatingUseCases.uploadPublicationUseCase.execute(data)
    }

    fun close() {

    }
}