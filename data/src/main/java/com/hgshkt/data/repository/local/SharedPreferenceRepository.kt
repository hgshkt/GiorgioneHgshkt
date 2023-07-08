package com.hgshkt.data.repository.local

import android.content.SharedPreferences
import com.hgshkt.domain.repository.user.Key
import com.hgshkt.domain.repository.user.LocalUserRepository


class SharedPreferenceRepository(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor
): LocalUserRepository {

    private val PREF_AUTH_ID_KEY = "auth id"
    override fun getCurrentUserKey(): Key {
        val authId = sharedPreferences.getString(PREF_AUTH_ID_KEY, "def value")!!
        return Key(authId = authId)
    }

    override fun saveCurrentUserKey(key: Key) {
        val authId = key.authId
        editor.putString(PREF_AUTH_ID_KEY, authId)
        editor.apply()
    }
}