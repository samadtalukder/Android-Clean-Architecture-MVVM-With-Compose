/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.data.datasource

import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import retrofit2.Response

interface GithubUserDataSource {
    suspend fun fetchUserDetails(username: String): Response<GitHubUserDetailResponse>
}