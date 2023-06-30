package com.hgshkt.giorgionehgshkt.ui.navigation.graphs.root

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RootNavigationGraphViewModel @Inject constructor(
    private val rootNavigationGraphUseCases: RootNavigationGraphUseCases
): ViewModel() {


    var startDestination = Graph.AUTH
        get() {
            val isSigned = rootNavigationGraphUseCases.checkAuthenticationUseCase.execute()
            return if (isSigned) {
                Graph.MAIN
            } else {
                Graph.AUTH
            }
        }
}