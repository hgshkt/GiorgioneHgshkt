package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ProfileScreen(
    userId: String
) {
    val viewModel = remember {
        ProfileViewModel(
            userId = userId
        )
    }
    val user = viewModel.user
    val publications = viewModel.publications

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Image(
                painter = rememberImagePainter(
                    data = user.value.avatarUrl
                ),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = user.value.name,
                modifier = Modifier.weight(1f)
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            items(publications.size) { index ->
                val publication = publications[index]
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(4.dp)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = publication.photoUrl
                        ),
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}