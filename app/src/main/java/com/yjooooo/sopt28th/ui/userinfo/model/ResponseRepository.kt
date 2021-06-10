package com.yjooooo.sopt28th.ui.userinfo.model

import com.google.gson.annotations.SerializedName

data class ResponseRepository(
    @SerializedName("language")
    val language: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)