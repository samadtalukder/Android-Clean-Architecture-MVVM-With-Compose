package com.samad_talukder.mvvmcompose.domain.usecase

import com.samad_talukder.mvvmcompose.data.remote.model.GitHubUserDetailResponse
import com.samad_talukder.mvvmcompose.data.remote.model.mapper.GithubUserDetailsMapper
import com.samad_talukder.mvvmcompose.domain.models.GitHubUserEntity
import com.samad_talukder.mvvmcompose.domain.repository.GithubUserDetailRepository
import com.samad_talukder.mvvmcompose.utils.ApiState
import com.samad_talukder.mvvmcompose.utils.UiState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GithubUserDetailUseCaseTest {

    private lateinit var repository: GithubUserDetailRepository
    private lateinit var mapper: GithubUserDetailsMapper
    private lateinit var useCase: GithubUserDetailUseCase

    @Before
    fun setup() {
        repository = mockk()
        mapper = mockk()
        useCase = GithubUserDetailUseCase(repository, mapper)
    }

    @Test
    fun `ApiState Success from repository emits UiState Success with mapped entity`() = runTest {
        val username = "john"
        val response = GitHubUserDetailResponse(
            avatar_url = "avatar",
            bio = "bio",
            blog = "blog",
            company = "company",
            created_at = "2025-01-01",
            email = "",
            events_url = "",
            followers = 10,
            followers_url = "",
            following = 5,
            following_url = "",
            gists_url = "",
            gravatar_id = "",
            hireable = false,
            html_url = "",
            id = 1,
            location = "Earth",
            login = username,
            name = "John",
            node_id = "",
            organizations_url = "",
            public_gists = 0,
            public_repos = 3,
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
        val entity = GitHubUserEntity(
            username = username,
            avatarUrl = "avatar",
            name = "John",
            company = "company",
            blog = "blog",
            location = "Earth",
            bio = "bio",
            publicRepos = 3,
            followers = 10,
            following = 5,
            joinedDate = "2025-01-01"
        )

        coEvery { repository.getUserDetails(username) } returns flowOf(ApiState.Success(response))
        every { mapper.mapFrom(response) } returns entity

        val result = useCase.invoke(username).first()

        assertEquals(UiState.Success(entity), result)
        coVerify(exactly = 1) { repository.getUserDetails(username) }
        verify(exactly = 1) { mapper.mapFrom(response) }
    }

    @Test
    fun `ApiState Error with not found message becomes UiState Error with friendly message`() = runTest {
        val username = "missing"
        val errorMessage = "User not found"
        coEvery { repository.getUserDetails(username) } returns flowOf(ApiState.Error(errorMessage))

        val result = useCase.invoke(username).first()

        assertEquals(
            UiState.Error("Resources not found. Please check the spelling and try again."),
            result
        )
    }

    @Test
    fun `ApiState Error with other message propagates to UiState Error`() = runTest {
        val username = "other"
        val errorMessage = "Internal server error"
        coEvery { repository.getUserDetails(username) } returns flowOf(ApiState.Error(errorMessage))

        val result = useCase.invoke(username).first()

        assertEquals(UiState.Error(errorMessage), result)
    }
}

