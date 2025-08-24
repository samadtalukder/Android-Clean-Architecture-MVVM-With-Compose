package com.samad_talukder.mvvmcompose

import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import com.samad_talukder.mvvmcompose.data.remote.model.mapper.GithubUserDetailsMapper
import com.samad_talukder.mvvmcompose.domain.models.GitHubUserEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class GithubUserDetailsMapperTest {
    private val mapper = GithubUserDetailsMapper()

    @Test
    fun `mapFrom returns GitHubUserEntity with expected fields`() {
        val response = GitHubUserDetailResponse(
            avatar_url = "https://example.com/avatar.png",
            bio = "Sample bio",
            blog = "https://blog.example.com",
            company = "Example Co",
            created_at = "2021-01-01T00:00:00Z",
            email = "sample@example.com",
            events_url = "",
            followers = 42,
            followers_url = "",
            following = 10,
            following_url = "",
            gists_url = "",
            gravatar_id = "",
            hireable = false,
            html_url = "",
            id = 123,
            location = "Earth",
            login = "sampleuser",
            name = "Sample User",
            node_id = "",
            organizations_url = "",
            public_gists = 0,
            public_repos = 7,
            received_events_url = "",
            repos_url = "",
            site_admin = false,
            starred_url = "",
            subscriptions_url = "",
            twitter_username = "",
            type = "",
            updated_at = "",
            url = "",
            user_view_type = ""
        )

        val expected = GitHubUserEntity(
            username = "sampleuser",
            avatarUrl = "https://example.com/avatar.png",
            name = "Sample User",
            company = "Example Co",
            blog = "https://blog.example.com",
            location = "Earth",
            bio = "Sample bio",
            publicRepos = 7,
            followers = 42,
            following = 10,
            joinedDate = "2021-01-01T00:00:00Z"
        )

        val entity = mapper.mapFrom(response)

        assertEquals(expected, entity)
    }
}

