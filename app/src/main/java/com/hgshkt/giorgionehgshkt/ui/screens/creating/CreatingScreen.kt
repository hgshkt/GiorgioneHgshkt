package com.hgshkt.giorgionehgshkt.ui.screens.creating

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.hgshkt.giorgionehgshkt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatingScreen() {

    val viewModel = hiltViewModel<CreatingViewModel>()

    val loadedUri = viewModel.uri
    val text = viewModel.text

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        loadedUri.value = uri
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .background(Color.Gray),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = rememberVectorPainter(image = Icons.Default.Close),
                contentDescription = "Upload image",
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
                    .clickable {
                        viewModel.close()
                    },
                contentScale = ContentScale.FillWidth
            )

            Image(
                painter = rememberVectorPainter(image = Icons.Default.Send),
                contentDescription = "Upload image",
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
                    .clickable {
                        viewModel.uploadPublication()
                    },
                contentScale = ContentScale.FillWidth
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = if (loadedUri.value == Uri.EMPTY)
                    painterResource(id = R.drawable.add_photo_gallery)
                else
                    rememberImagePainter(loadedUri.value),
                contentDescription = "Upload image",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.4f)
                    .border(width = 2.dp, color = Color.DarkGray)
                    .clickable {
                        launcher.launch("image/*")
                    },
                contentScale = ContentScale.FillHeight
            )

            TextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .padding(horizontal = 16.dp),
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }
    }
}