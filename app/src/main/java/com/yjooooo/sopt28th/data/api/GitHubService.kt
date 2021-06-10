package com.yjooooo.sopt28th.data.api

import com.yjooooo.sopt28th.ui.home.model.ResponseRepository
import com.yjooooo.sopt28th.ui.userinfo.model.ResponseFollow
import com.yjooooo.sopt28th.ui.userinfo.model.ResponseOrganization
import com.yjooooo.sopt28th.ui.userinfo.model.ResponseUserInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("/users/{username}")
    suspend fun getUserInfo(
        @Path("username") username: String
    ): ResponseUserInfo

    @GET("/users/{username}/repos")
    suspend fun getRepository(
        @Path("username") username: String
    ): List<ResponseRepository>

    @GET("/users/{username}/orgs")
    suspend fun getOrganization(
        @Path("username") username: String
    ): List<ResponseOrganization>

    @GET("/users/{username}/followers")
    suspend fun getFollowers(
        @Path("username") username: String
    ): List<ResponseFollow>

    @GET("/users/{username}/following")
    suspend fun getFollowings(
        @Path("username") username: String
    ): List<ResponseFollow>
}