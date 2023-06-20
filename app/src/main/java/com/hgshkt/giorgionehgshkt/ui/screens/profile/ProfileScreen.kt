package com.hgshkt.giorgionehgshkt.ui.screens.profile

import android.app.Activity
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.hgshkt.giorgionehgshkt.di.ViewModelFactoryProvider
import dagger.hilt.android.EntryPointAccessors

@Composable
fun ProfileScreen(
    userId: String
) {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        ViewModelFactoryProvider::class.java
    ).profileViewModelFactory()

    val viewModel = viewModel<ProfileViewModel>(
        factory = ProfileViewModel.provideProfileViewModelFactory(factory, userId)
    )

    val user = viewModel.user
    val publications = viewModel.publications

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
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