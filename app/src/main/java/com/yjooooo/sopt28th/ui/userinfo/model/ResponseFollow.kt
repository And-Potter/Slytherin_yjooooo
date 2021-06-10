package com.yjooooo.sopt28th.ui.userinfo.model

import com.google.gson.annotations.SerializedName

data class ResponseFollow(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)