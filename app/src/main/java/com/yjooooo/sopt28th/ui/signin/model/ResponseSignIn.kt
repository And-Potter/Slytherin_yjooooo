package com.yjooooo.sopt28th.ui.signin.model

import com.google.gson.annotations.SerializedName

data class ResponseSignIn(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("token")
        val token: String,
        @SerializedName("UserId")
        val userId: Int,
        @SerializedName("user_nickname")
        val userNickname: String
    )
}