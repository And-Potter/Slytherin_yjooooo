package com.yjooooo.sopt28th.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "http://cherishserver.com"
    private const val GITHUB_URL = "https://api.github.com"

    private val loginRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val githubRetrofit = Retrofit.Builder()
        .baseUrl(GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val loginService: LoginService = loginRetrofit.create(LoginService::class.java)
    val gitHubService: GitHubService = githubRetrofit.create(GitHubService::class.java)
}