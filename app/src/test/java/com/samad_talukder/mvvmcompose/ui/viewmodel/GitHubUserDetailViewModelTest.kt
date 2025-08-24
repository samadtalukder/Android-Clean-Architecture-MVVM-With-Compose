package com.samad_talukder.mvvmcompose.ui.viewmodel

import com.samad_talukder.mvvmcompose.domain.models.GitHubUserEntity
import com.samad_talukder.mvvmcompose.domain.usecase.GithubUserDetailUseCase
import com.samad_talukder.mvvmcompose.utils.UiState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class GitHubUserDetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val userDetailUseCase: GithubUserDetailUseCase = mockk()

    @Test
    fun `userState emits Loading then Success`() = runTest(mainDispatcherRule.dispatcher) {
        val username = "octocat"
        val entity = GitHubUserEntity(
            username = username,
            avatarUrl = "avatar",
            name = "Octo Cat",
            company = null,
            blog = null,
            location = null,
            bio = null,
            publicRepos = 1,
            followers = 2,
            following = 3,
            joinedDate = "2024-01-01"
        )

        coEvery { userDetailUseCase.invoke(username) } returns flowOf(UiState.Success(entity))

        val viewModel = GitHubUserDetailViewModel(userDetailUseCase)

        val emissions = mutableListOf<UiState<GitHubUserEntity>>()
        val job = launch { viewModel.userState.take(2).toList(emissions) }

        viewModel.loadUserDetailData(username)
        advanceUntilIdle()

        assertEquals(UiState.Loading, emissions[0])
        assertEquals(UiState.Success(entity), emissions[1])

        job.cancel()
    }

    @Test
    fun `userState emits Loading then Error`() = runTest(mainDispatcherRule.dispatcher) {
        val username = "octocat"
        val message = "Network Error"

        coEvery { userDetailUseCase.invoke(username) } returns flowOf(UiState.Error(message))

        val viewModel = GitHubUserDetailViewModel(userDetailUseCase)

        val emissions = mutableListOf<UiState<GitHubUserEntity>>()
        val job = launch { viewModel.userState.take(2).toList(emissions) }

        viewModel.loadUserDetailData(username)
        advanceUntilIdle()

        assertEquals(UiState.Loading, emissions[0])
        assertEquals(UiState.Error(message), emissions[1])

        job.cancel()
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class MainDispatcherRule(
    val dispatcher: TestDispatcher = StandardTestDispatcher()
) : TestWatcher() {
    override fun starting(description: Description) {
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}

