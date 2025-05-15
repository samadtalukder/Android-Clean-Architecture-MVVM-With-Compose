/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.domain.models.GitHubUserEntity
import com.samad_talukder.mvvmcompose.ui.common.components.CustomImage
import com.samad_talukder.mvvmcompose.ui.common.components.CustomText
import com.samad_talukder.mvvmcompose.ui.common.theme.GrayTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.HeaderBGColor
import com.samad_talukder.mvvmcompose.ui.common.theme.OrangeTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.RestaurantTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.White
import com.samad_talukder.mvvmcompose.ui.details.components.ErrorScreen
import com.samad_talukder.mvvmcompose.ui.details.components.LoadingScreen
import com.samad_talukder.mvvmcompose.ui.viewmodel.GitHubUserDetailViewModel
import com.samad_talukder.mvvmcompose.utils.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubUserDetailsScreen(
    onNavigateBack: () -> Unit,
    username: String,
    viewModel: GitHubUserDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = username) {
        if (username.isNotEmpty()) {
            viewModel.loadUserDetailData(username)
        }
    }

    val uiState by viewModel.userState.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (uiState) {
            is UiState.Loading -> {
                LoadingScreen()
            }

            is UiState.Success -> {
                val user = (uiState as UiState.Success<GitHubUserEntity>).data
                UserDetailsScreen(user = user)
            }

            is UiState.Error -> {
                val errorMessage = (uiState as UiState.Error).message
                ErrorScreen(
                    message = errorMessage,
                    onNavigateToHome = { onNavigateBack() }
                )
            }
        }
    }
}


@Composable
fun UserDetailsScreen(user: GitHubUserEntity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {

        UserHeader(user = user)
        UserName(username = user.username)
        Spacer(modifier = Modifier.height(24.dp))
        UserStats(user = user)

    }
}

@Composable
fun UserName(username: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(horizontal = 60.dp)
            .offset(x = 0.dp, y = (-20).dp)
            .background(OrangeTextColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        CustomText(
            text = "@${username}",
            textColor = White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun UserHeader(user: GitHubUserEntity) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(
                color = HeaderBGColor,
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context)
                    .data(user.avatarUrl)
                    .crossfade(true)
                    .placeholder(drawableResId = R.drawable.img_not_found)
                    .error(drawableResId = R.drawable.img_not_found)
                    .build()
            ),
            contentDescription = "image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            CustomText(
                text = user.name ?: "",
                textColor = White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(4.dp))

            CustomText(
                text = user.location ?: "",
                textColor = GrayTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomText(
                text = user.bio ?: "",
                textColor = GrayTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                maxLines = 1,
            )

            /*Text(
                text = "Joined ${user.joinedDate}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )*/
        }
        Spacer(modifier = Modifier.height(16.dp))

        SocialMediaItem()
    }


}

@Composable
fun SocialMediaItem() {
    Row {
        CustomImage(
            image = R.drawable.ic_mail,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(24.dp)
                .clickable {}
        )

        Spacer(Modifier.width(10.dp))

        CustomImage(
            image = R.drawable.ic_web_url,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(24.dp)
        )

        Spacer(Modifier.width(10.dp))

        CustomImage(
            image = R.drawable.ic_twitter,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(24.dp)
                .padding(2.dp)
        )
    }
}

@Composable
fun UserStats(user: GitHubUserEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        StatItem(
            label = "repositories",
            value = user.publicRepos.toString()
        )

        StatItem(
            label = "followers",
            value = user.followers.toString()
        )

        StatItem(
            label = "following",
            value = user.following.toString()
        )
    }
}

@Composable
fun StatItem(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomText(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textColor = RestaurantTextColor
        )

        Spacer(Modifier.height(4.dp))

        CustomText(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textColor = GrayTextColor
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewGithubUserDetailScreen() {
    UserDetailsScreen(
        user = GitHubUserEntity(
            username = "",
            avatarUrl = "",
            name = "",
            company = "",
            location = "",
            blog = "",
            bio = "",
            followers = 0,
            following = 0,
            joinedDate = "",
            publicRepos = 0
        )
    )

}

