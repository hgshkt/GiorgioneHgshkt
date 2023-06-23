package com.hgshkt.data.repository

import android.content.SharedPreferences
import com.hgshkt.domain.model.User
import com.hgshkt.domain.repository.user.LocalUserRepository


class SharedPreferenceRepository(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor
): LocalUserRepository {

    private val PREF_NAME_KEY = "name"
    private val PREF_ID_KEY = "id"
    private val PREF_AVATAR_URL_KEY = "avatarUrl"
    private val PREF_EMAIL_KEY = "email"
    private val PREF_PASSWORD_KEY = "password"
    private val PREF_AUTH_ID_KEY = "password"

    override fun getCurrentUser(): User {
        return User(
            name = sharedPreferences.getString(PREF_NAME_KEY, "")!!,
            id = sharedPreferences.getString(PREF_ID_KEY, "")!!,
            avatarUrl = sharedPreferences.getString(PREF_AVATAR_URL_KEY, "")!!,
            email = sharedPreferences.getString(PREF_EMAIL_KEY, "")!!,
            password = sharedPreferences.getString(PREF_PASSWORD_KEY, "")!!,
        )
    }

    override fun saveCurrentUser(user: User) {
        editor.putString(PREF_NAME_KEY, user.name)
        editor.putString(PREF_ID_KEY, user.id)
        editor.putString(PREF_AVATAR_URL_KEY, user.avatarUrl)
        editor.putString(PREF_EMAIL_KEY, user.email)
        editor.putString(PREF_PASSWORD_KEY, user.password)
        editor.apply()
    }

    override fun getCurrentUserAuthId(): String {
        return sharedPreferences.getString(PREF_AUTH_ID_KEY, "")!!
    }

    override fun saveCurrentUserAuthId(id: String) {
        editor.putString(PREF_AUTH_ID_KEY, id)
        editor.apply()
    }

}