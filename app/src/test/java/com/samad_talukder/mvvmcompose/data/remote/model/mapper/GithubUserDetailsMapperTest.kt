package com.samad_talukder.mvvmcompose.data.remote.model.mapper

import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import org.junit.Assert.assertEquals
import org.junit.Test

class GithubUserDetailsMapperTest {
    private val mapper = GithubUserDetailsMapper()

    @Test
    fun mapFrom_mapsAllFieldsCorrectly() {
        val response = GitHubUserDetailResponse(
            avatar_url = "https://avatars.githubusercontent.com/u/1",
            bio = "Sample bio",
            blog = "https://blog.example.com",
            company = "Example Co",
            created_at = "2020-01-01T00:00:00Z",
            email = "user@example.com",
            events_url = "events_url",
            followers = 10,
            followers_url = "followers_url",
            following = 5,
            following_url = "following_url",
            gists_url = "gists_url",
            gravatar_id = "",
            hireable = false,
            html_url = "html_url",
            id = 1,
            location = "Earth",
            login = "sample",
            name = "Sample User",
            node_id = "node123",
            organizations_url = "orgs_url",
            public_gists = 2,
            public_repos = 3,
            received_events_url = "received_events_url",
            repos_url = "repos_url",
            site_admin = false,
            starred_url = "starred_url",
            subscriptions_url = "subscriptions_url",
            twitter_username = "sample_twitter",
            type = "User",
            updated_at = "2020-01-02T00:00:00Z",
            url = "url",
            user_view_type = "public"
        )

        val entity = mapper.mapFrom(response)

        assertEquals(response.login, entity.username)
        assertEquals(response.avatar_url, entity.avatarUrl)
        assertEquals(response.name, entity.name)
        assertEquals(response.company, entity.company)
        assertEquals(response.blog, entity.blog)
        assertEquals(response.location, entity.location)
        assertEquals(response.bio, entity.bio)
        assertEquals(response.public_repos, entity.publicRepos)
        assertEquals(response.followers, entity.followers)
        assertEquals(response.following, entity.following)
        assertEquals(response.created_at, entity.joinedDate)
    }
}

