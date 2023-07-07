package com.hgshkt.giorgionehgshkt.ui.navigation

import androidx.lifecycle.ViewModel
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.MainScreen
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.Param
import com.hgshkt.giorgionehgshkt.ui.navigation.screens.ParamType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomNavigationViewModel @Inject constructor(
    private val useCases: BottomBarUseCases
) : ViewModel() {

    fun getPath(screen: MainScreen): String {
        val key = useCases.getCurrentUserKeyUseCase.execute()

        return if (screen == MainScreen.Profile) {
            MainScreen.Profile.withParams(
                listOf(
                    Param(
                        type = ParamType.UserId,
                        value = key.authId
                    )
                )
            )
        } else screen.route
    }
}