/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.data.remote

import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET(ApiPath.USER_DETAIL)
    suspend fun getUserDetail(
        @Path("username") username: String
    ): Response<GitHubUserDetailResponse>

}