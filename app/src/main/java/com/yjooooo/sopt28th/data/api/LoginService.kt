package com.yjooooo.sopt28th.data.api

import com.yjooooo.sopt28th.data.model.RequestSignIn
import com.yjooooo.sopt28th.data.model.RequestSignUp
import com.yjooooo.sopt28th.ui.signin.model.ResponseSignIn
import com.yjooooo.sopt28th.ui.signup.model.ResponseSignUp
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/login/signin")
    suspend fun postSignIn(
        @Body requestSignIn: RequestSignIn
    ): ResponseSignIn

    @POST("/login/signup")
    suspend fun postSignUp(
        @Body requestSignUp: RequestSignUp
    ): ResponseSignUp
}