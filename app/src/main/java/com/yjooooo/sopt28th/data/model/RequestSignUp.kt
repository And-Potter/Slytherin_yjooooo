package com.yjooooo.sopt28th.data.model

import com.google.gson.annotations.SerializedName

data class RequestSignUp(
    @SerializedName("birth")
    val birth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("sex")
    val sex: String
)