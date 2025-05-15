/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.data.datasource

import com.samad_talukder.mvvmcompose.data.remote.GithubApiService
import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import retrofit2.Response
import javax.inject.Inject


class GithubUserDataSourceImpl @Inject constructor(private var api: GithubApiService) :
    GithubUserDataSource {
    override suspend fun fetchUserDetails(username: String): Response<GitHubUserDetailResponse> {
        return api.getUserDetail(username)
    }
}