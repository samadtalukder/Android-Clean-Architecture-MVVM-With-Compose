/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.domain.models

data class GitHubUserEntity(
    val username: String,
    val avatarUrl: String,
    val name: String?,
    val company: String?,
    val blog: String?,
    val location: String?,
    val bio: String?,
    val publicRepos: Int,
    val followers: Int,
    val following: Int,
    val joinedDate: String
)