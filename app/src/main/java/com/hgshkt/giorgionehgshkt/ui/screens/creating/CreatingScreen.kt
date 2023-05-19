package com.hgshkt.giorgionehgshkt.ui.screens.creating

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatingScreen() {

    val viewModel = CreatingViewModel()

    val url = viewModel.url
    val text = viewModel.text

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            url.value = uri.toString()
        }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            Image(painter = rememberVectorPainter(image = Icons.Default.Close),
                contentDescription = "Upload image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .clickable {
                        viewModel.close()
                    },
                contentScale = ContentScale.FillWidth)

            Image(painter = rememberVectorPainter(image = Icons.Default.Send),
                contentDescription = "Upload image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .clickable {
                        viewModel.uploadPublication()
                    },
                contentScale = ContentScale.FillWidth)
        }
        Image(
            painter = rememberVectorPainter(image = Icons.Default.ArrowDropDown),
            contentDescription = "Upload image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .clickable {
                    launcher.launch("image/*")
                },
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 16.dp),
            textStyle = MaterialTheme.typography.bodyLarge
        )
    }
}