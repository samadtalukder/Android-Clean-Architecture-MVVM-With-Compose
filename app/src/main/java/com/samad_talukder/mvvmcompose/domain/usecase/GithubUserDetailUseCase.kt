/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.domain.usecase

import com.samad_talukder.mvvmcompose.data.remote.model.mapper.GithubUserDetailsMapper
import com.samad_talukder.mvvmcompose.domain.models.GitHubUserEntity
import com.samad_talukder.mvvmcompose.domain.repository.GithubUserDetailRepository
import com.samad_talukder.mvvmcompose.utils.ApiState
import com.samad_talukder.mvvmcompose.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GithubUserDetailUseCase @Inject constructor(
    private val userRepository: GithubUserDetailRepository,
    private val mapper: GithubUserDetailsMapper,
) {

    suspend fun invoke(username: String): Flow<UiState<GitHubUserEntity>> {
        return userRepository.getUserDetails(username).map { result ->
            when (result) {
                is ApiState.Success -> UiState.Success(mapper.mapFrom(result.data))
                is ApiState.Error -> {
                    val errorMessage = when {
                        result.message.contains(
                            "not found",
                            ignoreCase = true
                        ) -> "[${result.code}] resources not found. Please check the spelling and try again."

                        else -> result.message
                    }
                    UiState.Error(errorMessage)
                }
            }
        }
    }
}