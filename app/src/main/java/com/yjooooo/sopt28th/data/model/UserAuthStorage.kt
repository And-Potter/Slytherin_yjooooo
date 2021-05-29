package com.yjooooo.sopt28th.data.model

import android.content.Context

object UserAuthStorage {
    private const val STORAGE_KEY = "user_auth"
    private const val USER_ID = "id"
    private const val USER_PW = "pw"

    fun saveUserIdPw(context: Context, id: String, pw: String) {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit()
            .putString(USER_ID, id)
            .putString(USER_PW, id)
            .apply()
    }

    fun getUserId(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_ID, "") ?: ""
    }

    fun getUserPw(context: Context): String {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(USER_PW, "") ?: ""
    }

    fun hasUserData(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences(
            "${context.packageName}.$STORAGE_KEY",
            Context.MODE_PRIVATE
        )
        return !sharedPreferences.getString(USER_ID, "").isNullOrBlank() &&
                !sharedPreferences.getString(USER_PW, "").isNullOrBlank()
    }
}