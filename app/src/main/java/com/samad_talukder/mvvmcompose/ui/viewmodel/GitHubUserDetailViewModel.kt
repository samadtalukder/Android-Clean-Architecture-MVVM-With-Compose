/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samad_talukder.mvvmcompose.domain.models.GitHubUserEntity
import com.samad_talukder.mvvmcompose.domain.usecase.GithubUserDetailUseCase
import com.samad_talukder.mvvmcompose.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GitHubUserDetailViewModel @Inject constructor(
    private val userDetailUseCase: GithubUserDetailUseCase
) : ViewModel() {
    private val _userState = MutableStateFlow<UiState<GitHubUserEntity>>(UiState.Loading)
    val userState: StateFlow<UiState<GitHubUserEntity>> = _userState.asStateFlow()

    fun loadUserDetailData(username: String) {
        viewModelScope.launch {
            userDetailUseCase.invoke(username)
                .onStart { _userState.value = UiState.Loading }
                .catch { error -> _userState.value = UiState.Error("${error.localizedMessage}") }
                .collect { result ->
                    _userState.value = result
                }
        }
    }
}