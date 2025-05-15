/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.data.remote.model.mapper

import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import com.samad_talukder.mvvmcompose.domain.models.GitHubUserEntity
import com.samad_talukder.mvvmcompose.utils.CustomMapper
import javax.inject.Inject

class GithubUserDetailsMapper @Inject constructor() :
    CustomMapper<GitHubUserDetailResponse, GitHubUserEntity> {
    override fun mapFrom(from: GitHubUserDetailResponse): GitHubUserEntity {
        return GitHubUserEntity(
            username = from.login,
            avatarUrl = from.avatar_url,
            name = from.name,
            company = from.company,
            blog = from.blog,
            location = from.location,
            bio = from.bio,
            publicRepos = from.public_repos,
            followers = from.followers,
            following = from.following,
            joinedDate = from.created_at
        )
    }
}
