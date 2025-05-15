/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.components.CustomImage
import com.samad_talukder.mvvmcompose.ui.common.components.CustomText
import com.samad_talukder.mvvmcompose.ui.common.theme.BGColor
import com.samad_talukder.mvvmcompose.ui.common.theme.ButtonColor
import com.samad_talukder.mvvmcompose.ui.common.theme.GrayTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetails: (String) -> Unit,
) {
    val username: String? = null
    var searchQuery by remember { mutableStateOf(username ?: "") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BGColor),
        contentAlignment = Alignment.Center
    ) {
        InputTypeScreen(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onNavigateToDetail = {
                if (it.isNotEmpty()) {
                    onNavigateToDetails(searchQuery)
                }
            }
        )
    }

}

@Composable
fun InputTypeScreen(
    query: String,
    onQueryChange: (String) -> Unit,
    onNavigateToDetail: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(20.dp)
        ) {
            CustomImage(
                image = R.drawable.img_github,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Spacer(modifier = Modifier.height(60.dp))

            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Type Github Username") },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = White,
                    unfocusedBorderColor = White,
                    focusedContainerColor = White,
                    unfocusedContainerColor = White,
                    cursorColor = GrayTextColor,
                    focusedTextColor = Black,
                    unfocusedTextColor = Black
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (query.isNotEmpty()) {
                            onNavigateToDetail(query)
                        }
                    }
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    if (query.isNotEmpty()) {
                        onNavigateToDetail(query)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor
                ),
                shape = RoundedCornerShape(8.dp),
                enabled = query.isNotEmpty()
            ) {
                CustomText(
                    text = "Submit",
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    letterSpacing = 0.5.sp,
                    textColor = if (query.isNotEmpty()) ButtonColor else GrayTextColor
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewGithubUserDetailsScreen() {
    HomeScreen(onNavigateToDetails = {})
}