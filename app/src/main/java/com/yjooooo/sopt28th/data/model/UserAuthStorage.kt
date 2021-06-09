package com.yjooooo.sopt28th.data.model

import android.content.Context
import android.content.SharedPreferences

object UserAuthStorage {
    private const val STORAGE_KEY = "user_auth"
    private const val USER_ID = "id"
    private const val USER_PW = "pw"

    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
    }

    fun saveUserIdPw(id: String, pw: String) {
        sharedPreferences.edit()
            .putString(USER_ID, id)
            .putString(USER_PW, pw)
            .apply()
    }

    fun getUserId(): String {
        return sharedPreferences.getString(USER_ID, "") ?: ""
    }

    fun getUserPw(): String {
        return sharedPreferences.getString(USER_PW, "") ?: ""
    }

    fun hasUserData(): Boolean {
        return !sharedPreferences.getString(USER_ID, "").isNullOrBlank() &&
                !sharedPreferences.getString(USER_PW, "").isNullOrBlank()
    }
}