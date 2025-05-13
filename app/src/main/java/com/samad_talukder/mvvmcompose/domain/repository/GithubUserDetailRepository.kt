/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.domain.repository

import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import com.samad_talukder.mvvmcompose.utils.ApiState
import kotlinx.coroutines.flow.Flow

interface GithubUserDetailRepository {
    suspend fun getUserDetails(username: String): Flow<ApiState<GitHubUserDetailResponse>>
}