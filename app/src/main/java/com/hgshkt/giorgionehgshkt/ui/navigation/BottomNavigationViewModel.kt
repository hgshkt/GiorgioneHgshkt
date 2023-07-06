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
        return if (screen == MainScreen.Profile) {
            MainScreen.Profile.withParams(
                listOf(
                    Param(
                        type = ParamType.UserId,
                        value = useCases.getCurrentUserIdUseCase.execute()
                    )
                )
            )
        } else screen.route
    }
}