package com.yjooooo.sopt28th.data.model

import com.google.gson.annotations.SerializedName

data class RequestSignIn(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)