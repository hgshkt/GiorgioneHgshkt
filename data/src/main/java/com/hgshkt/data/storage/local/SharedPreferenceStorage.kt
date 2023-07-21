package com.hgshkt.data.storage.local

import android.content.SharedPreferences
import com.hgshkt.data.storage.keys.StorageUserKey

class SharedPreferenceStorage(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor,
): LocalStorage {

    private val PREF_AUTH_ID_KEY = "auth id"

    override fun getCurrentUserKey(): StorageUserKey {
        val value = sharedPreferences.getString(PREF_AUTH_ID_KEY, "def value")!!
        return StorageUserKey(value = value)
    }

    override fun saveCurrentUserKey(key: StorageUserKey) {
        val value = key.value
        editor.putString(PREF_AUTH_ID_KEY, value)
        editor.apply()
    }
}