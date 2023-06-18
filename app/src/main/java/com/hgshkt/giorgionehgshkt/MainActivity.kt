package com.hgshkt.giorgionehgshkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hgshkt.giorgionehgshkt.ui.screens.profile.ProfileScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen("l0rCBGOi9cb8p7XC9noRU7GCYMD2")
        }
    }
}