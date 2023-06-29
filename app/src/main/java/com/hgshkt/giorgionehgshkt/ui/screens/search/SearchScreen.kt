package com.hgshkt.giorgionehgshkt.ui.screens.search

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.hgshkt.giorgionehgshkt.di.ViewModelFactoryProvider
import dagger.hilt.android.EntryPointAccessors

@Composable
fun SearchScreen(
    navController: NavHostController
) {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        ViewModelFactoryProvider::class.java
    ).searchViewModelFactory()

    val viewModel = viewModel<SearchViewModel>(
        factory = SearchViewModel.provideSearchViewModelFactory(factory, navController)
    )

    val text = viewModel.text

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
        ) {
            TextField(
                value = text.value,
                onValueChange = { text.value = it },
                label = { Text(text = "ID") },
                modifier = Modifier.fillMaxWidth(0.9f)
            )
            Image(
                painter = rememberVectorPainter(image = Icons.Default.Search),
                contentDescription = "Search",
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
                    .clickable {
                        viewModel.search()
                    },
                contentScale = ContentScale.FillWidth
            )
        }
    }
}