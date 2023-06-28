package com.hgshkt.giorgionehgshkt.ui.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.Param
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.ParamType

class SearchViewModel(
    private val navController: NavController
): ViewModel() {

    val text = mutableStateOf("")

    fun search() {
        val userId = text.value
        val params = listOf(
            Param(ParamType.UserId, userId)
        )
        navController.navigate(MainScreen.Profile.withParams(params))
    }
}