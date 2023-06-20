package com.hgshkt.giorgionehgshkt.ui.screens.profile

import androidx.compose.runtime.Composable
import org.junit.Test

class ProfileMainScreenKtTest {

    @Test
    @Composable
    fun profileScreen() {
        ProfileScreen(userId = "testUserId")
    }
}