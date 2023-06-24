package com.hgshkt.giorgionehgshkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.hgshkt.domain.authentication.LoginService
import com.hgshkt.giorgionehgshkt.ui.navigation.AppBottomNavigation
import com.hgshkt.giorgionehgshkt.ui.navigation.AuthNavHost
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var loginService: LoginService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val isSigned = remember {
                mutableStateOf(loginService.isSigned())
            }

            if (isSigned.value) {
                AppBottomNavigation(navController)
            } else {
                AuthNavHost(navController = navController)
            }
        }
    }
}