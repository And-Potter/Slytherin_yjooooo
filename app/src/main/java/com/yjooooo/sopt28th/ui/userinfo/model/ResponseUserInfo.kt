package com.yjooooo.sopt28th.ui.userinfo.model

import com.google.gson.annotations.SerializedName

data class ResponseUserInfo(
    @SerializedName("login")
    val login: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("company")
    val company: String
)