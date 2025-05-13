/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.domain.repository

import com.samad_talukder.mvvmcompose.data.datasource.GithubUserDataSource
import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import com.samad_talukder.mvvmcompose.utils.ApiState
import com.samad_talukder.mvvmcompose.utils.DispatchersProvider
import com.samad_talukder.mvvmcompose.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GithubUserDetailRepositoryImpl @Inject constructor(
    private val userDataSource: GithubUserDataSource,
    private val dispatchersProvider: DispatchersProvider,
) : GithubUserDetailRepository {

    override suspend fun getUserDetails(username: String): Flow<ApiState<GitHubUserDetailResponse>> {
        return flow {

            val result = safeApiCall { userDataSource.fetchUserDetails(username) }
            emit(result)

        }.flowOn(dispatchersProvider.io())
    }
}