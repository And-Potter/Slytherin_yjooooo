package com.yjooooo.sopt28th.ui.home.model

import com.google.gson.annotations.SerializedName

data class ResponseRepository(
    @SerializedName("language")
    var language: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)