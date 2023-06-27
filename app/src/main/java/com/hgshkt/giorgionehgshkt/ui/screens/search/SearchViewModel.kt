package com.hgshkt.giorgionehgshkt.ui.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class SearchViewModel(
    private val navController: NavController
): ViewModel() {

    val text = mutableStateOf("")

    fun search() {
        navController//.navigate(text)
    }
}