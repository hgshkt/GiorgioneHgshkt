package com.hgshkt.giorgionehgshkt.ui.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.Param
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.ParamType
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SearchViewModel @AssistedInject constructor(
    @Assisted
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

    @AssistedFactory
    interface Factory {
        fun create(navController: NavController): SearchViewModel
    }

    companion object {
        fun provideSearchViewModelFactory(
            factory: Factory,
            navController: NavController
        ) : ViewModelProvider.Factory {
            return object: ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(navController) as T
                }
            }
        }
    }
}